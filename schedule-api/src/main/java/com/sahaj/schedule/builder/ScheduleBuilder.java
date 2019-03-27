package com.sahaj.schedule.builder;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.sahaj.schedule.daily.DailyScheduleBuilder;
import com.sahaj.schedule.once.NonRecurringScheduleBuilder;
import com.sahaj.schedule.weekly.WeeklyScheduleBuilder;

public class ScheduleBuilder {

    private String eventName;

    protected ScheduleBuilder(String eventName) {
        this.eventName = eventName;
    }

    public static ScheduleBuilder newSchedule(String eventName) {
        return new ScheduleBuilder(eventName);
    }

    public NonRecurringScheduleBuilder once() {
        return new NonRecurringScheduleBuilder(this.eventName);
    }

    public DailyScheduleBuilder daily() {
        return new DailyScheduleBuilder(this.eventName);
    }

    public WeeklyScheduleBuilder weekly(DayOfWeek dayofWeek, DayOfWeek... daysOfWeek) {
        Set<DayOfWeek> daysOfWeekSet = new TreeSet<>(Arrays.asList(daysOfWeek));
        daysOfWeekSet.add(dayofWeek);

        return new WeeklyScheduleBuilder(this.eventName, daysOfWeekSet);
    }

}