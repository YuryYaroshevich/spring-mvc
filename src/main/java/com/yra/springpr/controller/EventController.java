package com.yra.springpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yra.springpr.service.EventService;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView getEvents() {
        ModelAndView model = new ModelAndView("jsonView");
        model.addObject(eventService.getAll());
        return model;
    }
    
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public ModelAndView getEvent(@PathVariable int id) {
        ModelAndView model = new ModelAndView("jsonView");
        model.addObject(eventService.getAll().get(id));
        return model;
    }
}
