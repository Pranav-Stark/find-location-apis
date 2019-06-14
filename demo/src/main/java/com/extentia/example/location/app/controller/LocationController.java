/**
 * 
 */
package com.extentia.example.location.app.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extentia.example.location.app.services.FoursquareService;
import com.extentia.example.location.app.services.GoogleService;
import com.extentia.example.location.app.services.GoogleServiceByGoogleClasses;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Pranav.Kadam
 *
 */
@RestController
@RequestMapping("/location/apis/v1")
@Api(tags = {"LocationController"} )
public class LocationController {

	@Autowired
	private GoogleService googleService;

	@Autowired
	private GoogleServiceByGoogleClasses googleServiceByGoogleClasses;
	
	@Autowired
	private FoursquareService foursquareService;

	private static final Logger LOGGER = Logger.getLogger(LocationController.class.getName());

	@RequestMapping(value = "/getAutoCompletedLocations",method = RequestMethod.GET)
	@ApiOperation(value = "Get autocompleted location results on given input text")
	public String getAutoCompletedLocations(@RequestParam(name = "location") String textToComplete) {

		LOGGER.info("getAutoCompletedLocations() API called ...");
		
		/*GoogleService getAutoCompletedLocationResults() API call*/
		String autoCompletedLocations = googleServiceByGoogleClasses.getAutoCompletedLocationResults(textToComplete);

		LOGGER.info("getAutoCompletedLocations() API call completed.");

		return autoCompletedLocations;

	}

	@RequestMapping(value = "/getSearchedLocation",method = RequestMethod.GET)
	@ApiOperation(value = "Get perticular location result on given input text")
	public String getSearchedLocation(@RequestParam(name = "location") String placeToFind) {

		LOGGER.info("getSearchedLocation() API called ...");

		/*GoogleService findLocationFromText() API call*/
		String searchedLocation = googleService.findLocationFromText(placeToFind);

		LOGGER.info("getSearchedLocation() API call completed.");

		return searchedLocation;

	}

	@RequestMapping(value = "/getNearByLocations",method = RequestMethod.GET)
	@ApiOperation(value = "Get near-by location results on given input text")
	public String getNearByLocations(@RequestParam(name = "longitude_latitude") String longitude_latitude,
			@RequestParam(name = "radius") String radius, @RequestParam(name = "type") String type,
			@RequestParam(name = "keyword") String keyWord) {

		LOGGER.info("getNearByLocations() API called ...");
		
		/*GoogleService findNearByLocations() API call*/
		String nearByLocation = googleService.findNearByLocations(longitude_latitude, radius, type, keyWord);

		LOGGER.info("getNearByLocations() API call completed.");
		
		return nearByLocation;

	}
	
	
	@RequestMapping(value = "/getFilteredLocationOnCategory",method = RequestMethod.GET)
	@ApiOperation(value = "Get filtered location results on given input category Id like Movie Theater(4bf58dd8d48988d17f941735)etc")
	public String getFilteredLocationOnCategory(@RequestParam(name = "longitude_latitude") String longitude_latitude,
			@RequestParam(name = "categoryId") String categoryId) {

		LOGGER.info("getFilteredLocationOnCategory() API called ...");

		/*FoursquareService findFilteredLocations() API call*/
		String filteredPlaces = foursquareService.findFilteredLocations(longitude_latitude, categoryId);

		LOGGER.info("getFilteredLocationOnCategory() API call completed.");

		return filteredPlaces;
	}
	
	@RequestMapping(value = "/getExploredLocation",method = RequestMethod.GET)
	@ApiOperation(value = "Get deatiled location")
	public String getExploredLocation(@RequestParam(name = "longitude_latitude") String longitude_latitude) {

		LOGGER.info("getExploredLocation() API called ...");

		/*FoursquareService exploreGivenLocation() API call*/
		String filteredPlaces = foursquareService.exploreGivenLocation(longitude_latitude);

		LOGGER.info("getExploredLocation() API call completed.");

		return filteredPlaces;
	}

}
