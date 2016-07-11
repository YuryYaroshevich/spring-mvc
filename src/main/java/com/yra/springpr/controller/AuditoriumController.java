package com.yra.springpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yra.springpr.model.Auditorium;
import com.yra.springpr.service.AuditoriumService;

@RestController
@RequestMapping("/auditorium")
public class AuditoriumController {
	@Autowired
	private AuditoriumService auditoriumService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Auditorium> getAuditoriums() {
		return auditoriumService.getAuditoriums();
	}
}
