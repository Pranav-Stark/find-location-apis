/**
 * 
 */
package com.extentia.example.location.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.extentia.example.location.app.services.FoursquareService;
import com.extentia.example.location.app.services.GoogleService;
import com.extentia.example.location.app.services.GoogleServiceByGoogleClasses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Pranav.Kadam
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTest {

	@Mock
	private GoogleService googleService;
	
	@Mock
	private GoogleServiceByGoogleClasses googleServiceByGoogleClasses;
	
	@Mock
	private FoursquareService foursquareService;

	@Test
	public void testFindLocationFromText() {
	  when(googleService.findLocationFromText("SomeLocation")).thenReturn("Result");
		
	  assertEquals("Result", googleService.findLocationFromText("SomeLocation"));
	 }
	
	@Test
	public void testFindNearByLocations() {
	  when(googleService.findNearByLocations("SomeLocation", "radius", "type", "keyWord")).thenReturn("Result");
		
	  assertEquals("Result", googleService.findNearByLocations("SomeLocation", "radius", "type", "keyWord"));
	 }
	
	@Test
	public void testAutoCompletedLocationResults() {
	  when(googleServiceByGoogleClasses.getAutoCompletedLocationResults("textToComplete")).thenReturn("Result");
		
	  assertEquals("Result", googleServiceByGoogleClasses.getAutoCompletedLocationResults("textToComplete"));
	 }
	
	@Test
	public void testFindFilteredLocations() {
	  when(foursquareService.findFilteredLocations("longitude_latitude", "categoryId")).thenReturn("Result");
		
	  assertEquals("Result", foursquareService.findFilteredLocations("longitude_latitude", "categoryId"));
	 }
	
	@Test
	public void testExploreGivenLocation() {
	  when(foursquareService.exploreGivenLocation("longitude_latitude")).thenReturn("Result");
		
	  assertEquals("Result", foursquareService.exploreGivenLocation("longitude_latitude"));
	 }

	
}
