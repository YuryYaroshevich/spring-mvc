package com.yra.springpr.springmvc.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.google.common.collect.Lists;
import com.yra.springpr.controller.EventController;
import com.yra.springpr.model.Event;
import com.yra.springpr.model.EventTimetable;
import com.yra.springpr.model.Rating;
import com.yra.springpr.service.EventService;


@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    EventController ctor;
    
    @Mock
    EventService eventService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        this.mockMvc = standaloneSetup(ctor)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }
    
    @Test
    public void testCreateEvent() throws Exception {
        mockMvc.perform(
                post("/event?dates={dates}", "2016-06-27T15:57:36.505Z, 2016-06-28T14:27:36.505Z")
                .content("{\"name\": \"sfs\", \"basePrice\": \"23\", \"rating\": \"HIGH\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
         .andExpect(status().isCreated());
        
        verify(eventService, times(1)).create(any(Event.class), any(List.class));
    }
    
    @Test
    public void testDeleteEvent() throws Exception {
    	mockMvc.perform(delete("/event/{id}", 3))
    		.andDo(print())
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.message").value("Event was deleted."))
    		.andExpect(jsonPath("$.error").value(false));
    	
    	verify(eventService, times(1)).remove(3);
    }
    
    @Test
    public void testGetEvent() throws Exception {
    	Event event = new Event(3, "batman", Rating.MID, 45.6);
    	event.setTimetable(Lists.newArrayList(
    			new EventTimetable(1, event, new Date()),
    			new EventTimetable(2, event, new Date())));
    	
    	when(eventService.get(3)).thenReturn(event);
    	
    	mockMvc.perform(get("/event/{id}", 3))
    		.andDo(print())
    		.andExpect(status().isOk())
    		.andExpect(jsonPath("$.id").value(3))
    		.andExpect(jsonPath("$.name").value("batman"))
    		.andExpect(jsonPath("$.rating").value("MID"))
    		.andExpect(jsonPath("$.basePrice").value(45.6))
    		.andExpect(jsonPath("$.timetable[0].id").value(1))
    		.andExpect(jsonPath("$.timetable[1].id").value(2));
    }
}
