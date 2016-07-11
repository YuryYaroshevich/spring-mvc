package com.yra.springpr.springmvc.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.yra.springpr.controller.AuditoriumController;
import com.yra.springpr.model.Auditorium;
import com.yra.springpr.service.AuditoriumService;


@RunWith(MockitoJUnitRunner.class)
public class AuditoriumControllerTest {
	MockMvc mockMvc;
    
    @InjectMocks
    AuditoriumController ctor;
    
    @Mock
    AuditoriumService auditoriumService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        this.mockMvc = standaloneSetup(ctor)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }
    
    @Test
    public void testGetAuditoriums() throws Exception {
    	final int ID = 3;
    	final int SEATS_NUMBER = 100;
    	final Set<Integer> VIP_SEATS = ImmutableSet.<Integer> of(4,5,6);
    	final int VIP_SEAT_PRICE = 34;
    	when(auditoriumService.getAuditoriums()).thenReturn(Lists.newArrayList(
    			new Auditorium(ID, SEATS_NUMBER, VIP_SEATS, VIP_SEAT_PRICE)
		));
    	
    	mockMvc.perform(get("/auditorium"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0].id").value(ID))
			.andExpect(jsonPath("$.[0].seatsNumber").value(SEATS_NUMBER))
			.andExpect(jsonPath("$.[0].vipSeats[0]").value(4))
			.andExpect(jsonPath("$.[0].vipSeats[1]").value(5))
			.andExpect(jsonPath("$.[0].vipSeats[2]").value(6))
			.andExpect(jsonPath("$.[0]vipSeatPrice").value(VIP_SEAT_PRICE));
    }
}
