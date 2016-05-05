package com.yra.springpr.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yra.springpr.model.Event;
import com.yra.springpr.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getEvents() {
        return eventService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable int id) {
        return eventService.getAll().get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)/*, @RequestParam Date dates*/
    public ResponseEntity<Event> create(@RequestBody Event event) {
        event = eventService.create(event, event.getDates());
        ResponseEntity<Event> response = new ResponseEntity<>(event, HttpStatus.CREATED);
        return response;
    }
}
