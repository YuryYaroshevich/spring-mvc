package com.yra.springpr.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yra.springpr.model.Event;
import com.yra.springpr.service.EventService;
import com.yra.springpr.service.TimetableService;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private TimetableService timetableService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable long id) {
        return eventService.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces="application/json")
    public ResponseEntity<Event> create(@RequestBody Event event, 
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX") List<Date> dates) {
        event = eventService.create(event, dates);
        ResponseEntity<Event> response = new ResponseEntity<>(event, HttpStatus.CREATED);
        return response;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException1(Exception ex)
    {
        return ex.getMessage();
    }
}
