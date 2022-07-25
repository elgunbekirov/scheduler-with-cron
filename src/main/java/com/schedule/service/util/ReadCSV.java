package com.schedule.service.util;

import com.opencsv.bean.CsvToBeanBuilder;
import com.schedule.service.model.TimeModel;
import lombok.SneakyThrows;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

public class ReadCSV {

    @SneakyThrows
    public static List<TimeModel> getListFromCSVFile(String fileName ) {

        ClassLoader classLoader = ReadCSV.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("csv file not found! " + fileName);
        }

        List<TimeModel> list = new CsvToBeanBuilder(new FileReader(resource.getFile()))
                .withType(TimeModel.class)
                .build()
                .parse();
        return list;
    }
}