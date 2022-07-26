package com.schedule.service.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.schedule.service.model.TimeModel;
import com.schedule.service.util.ReadCSV;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author elgun.bakirov
 */

@Component
public class ScheduledTasks {

	@Value("${time.config.cron}")
	String timeConfigValue;

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

	@SneakyThrows
	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		//LOG.info("Fixed rate task = " + LocalDateTime.now());
	}

	@SneakyThrows
	@Scheduled(fixedDelay = 3000)
	public void scheduleTaskWithFixedDelay() {
		//LOG.info("Fixed delay task = " + LocalDateTime.now());
	}

	@SneakyThrows
	@Scheduled(fixedRate = 2000, initialDelay = 5000)
	public void scheduleTaskWithInitialDelay() {
		//LOG.info("Fixed rate Task with initial delay = " + LocalDateTime.now());
	}

	@SneakyThrows
	@Scheduled(cron = "${time.config.cron}")
	public void scheduleTaskWithCronExpression() {

		Instant instant = Instant.now();
		ZoneId zoneId = ZoneId.of("Africa/Lagos");
		ZonedDateTime zdt = ZonedDateTime.ofInstant(instant ,zoneId);
		DayOfWeek dayOfWeek = zdt.getDayOfWeek();

		List<TimeModel> actionCheckList = new ArrayList<>();// ReadCSV.getListFromCSVFile("data.csv");
		if(actionCheckList == null || actionCheckList.size() == 0){
			actionCheckList.add(new TimeModel("03:20", 2));
			actionCheckList.add(new TimeModel("03:58", 5));
		}

		actionCheckList.
				   stream()
						.forEach( timeModel -> { runImaginaryEvent(timeModel, dayOfWeek);});

	}

	@SneakyThrows
	public void runImaginaryEvent(TimeModel timeModel, DayOfWeek dayOfWeek){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.now();
		if(timeModel.getBitmask().equals(dayOfWeek.getValue()) &&  dtf.format(localTime).equals(timeModel.getTime())) {
			LOG.info("Imaginary action has been executed. Current time is = " + LocalDateTime.now());
		}

	}

}
