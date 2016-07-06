package com.yra.springpr.service;

import java.util.Date;
import java.util.List;

import com.yra.springpr.dao.EventDao;
import com.yra.springpr.model.Auditorium;
import com.yra.springpr.model.Event;
import com.yra.springpr.model.EventTimetable;

public class EventServiceImpl implements EventService {
    private EventDao eventDao;
    
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event create(Event event, List<Date> dates) {
        event = eventDao.save(event, dates);
        return event;
    }

    @Override
    public void remove(long id) {
        eventDao.remove(id);
    }

    @Override
    public Event getByName(String name) {
        return eventDao.getByName(name);
    }

    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public List<Event> getForDateRange(Date from, Date to) {
        return eventDao.getForDateRange(from, to);
    }

    @Override
    public List<Event> getNextEvents(Date to) {
        return eventDao.getNextEvents(to);
    }

    @Override
    public void assignAuditorium(EventTimetable eventTimetable,
            Auditorium auditorium) {
        eventDao.assignAuditorium(eventTimetable, auditorium);
    }

    @Override
    public Event get(long id) {
        return eventDao.get(id);
    }

}
