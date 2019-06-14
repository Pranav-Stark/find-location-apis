package com.extentia.example.location.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void positiveTestAutoCompletedLocation() {
		try {
			this.mvc.perform(get("/location/apis/v1/getAutoCompletedLocations").param("location", "Pun")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void positiveTestSearchedLocation() {
		try {
			this.mvc.perform(get("/location/apis/v1/getSearchedLocation").param("location", "Pune")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void positiveTestFilteredLocationOnCategory() {
		try {
			this.mvc.perform(get("/location/apis/v1/getFilteredLocationOnCategory").param("longitude_latitude", "18.1021612,74.2119388").param("categoryId", "4d4b7105d754a06372d81259")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void negativeTestAutoCompletedLocation() {
		try {
			this.mvc.perform(get("/location/apis/v1/getFilteredLocationOnCategory")).andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void negativeTestSearchedLocation() {
		try {
			this.mvc.perform(get("/location/apis/v1/getAutoCompletedLocations")).andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void negativeTestFilteredLocationOnCategory() {
		try {
			this.mvc.perform(get("/location/apis/v1/getSearchedLocation")).andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
