package com.schedule.service.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeModel {
    LocalTime time;
    Integer bitmask;
}
