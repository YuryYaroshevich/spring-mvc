package com.yra.springpr.service;

import java.util.Date;
import java.util.List;

import com.yra.springpr.model.Auditorium;
import com.yra.springpr.model.Event;
import com.yra.springpr.model.EventTimetable;

public interface EventService {

    Event create(Event event, List<Date> dates);

    void remove(Event event);

    Event getByName(String name);
    
    Event get(long id);

    List<Event> getAll();

    List<Event> getForDateRange(Date from, Date to);

    List<Event> getNextEvents(Date to);

    void assignAuditorium(EventTimetable eventTimetable, Auditorium auditorium);

}