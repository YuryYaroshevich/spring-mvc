package com.yra.springpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yra.springpr.model.Event;
import com.yra.springpr.service.EventService;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getAll();
    }
    
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable int id) {
        return eventService.getAll().get(id);
    }
}
