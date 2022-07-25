package com.schedule.service.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author elgun.bakirov
 */

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "spring.enable.scheduling")
public class ScheduleEnabling {

}
