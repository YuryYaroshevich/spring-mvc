package com.yra.springpr.service;

import java.util.Date;
import java.util.List;

import com.yra.springpr.dao.EventDao;
import com.yra.springpr.model.Event;

public class EventServiceImpl implements EventService {
    private EventDao eventDao;
    private TimetableService timetableService;

	public EventServiceImpl(EventDao eventDao, TimetableService timetableService) {
		this.eventDao = eventDao;
		this.timetableService = timetableService;
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
    public Event get(long id) {
    	Event event = eventDao.get(id);
    	event.setTimetable(timetableService.getTimetable(event));
        return event;
    }
}
