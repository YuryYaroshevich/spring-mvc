package com.yra.springpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yra.springpr.controller.util.InfoMessage;
import com.yra.springpr.service.EventService;
import com.yra.springpr.service.TimetableService;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private EventService eventService;
	
    @RequestMapping(value = "/{timetableId}", method = RequestMethod.PUT)
    public InfoMessage assignAuditorium(@PathVariable long timetableId, @RequestParam int auditoriumId) {
    	timetableService.assignAuditorium(timetableId, auditoriumId);
    	return new InfoMessage("Auditorium with id = " + auditoriumId + " was assigned.");
    }
}
