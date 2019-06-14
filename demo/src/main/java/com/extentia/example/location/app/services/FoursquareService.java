/**
 * 
 */
package com.extentia.example.location.app.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.extentia.example.location.app.constant.APIConstant;

/**
 * @author Pranav.Kadam
 *
 */
@Service
public class FoursquareService {

	private static final Logger LOGGER = Logger.getLogger(FoursquareService.class.getName());
	
	/*Business logic for findFilteredLocations() API */
	public String findFilteredLocations(String longitude_latitude, String categoryId) {

		LOGGER.info("findFilteredLocations() Service called ...");

		/*API configured along with given inputs*/
		String API_URL = APIConstant.FOURSQUARE_BASE_API_FOR_GET_FILTERED_PLACES + "&categoryId=" + categoryId + "&ll="
				+ longitude_latitude;

		RestTemplate restClient = new RestTemplate();
		
		/*Third party API called - Foursquare API*/
		String foursquareFilteredAPIResponse = restClient.getForObject(API_URL, String.class);

		LOGGER.info("findFilteredLocations() Service response received & returned.");

		return foursquareFilteredAPIResponse;
	}
	
	/*Business logic for exploreGivenLocation() API */
	public String exploreGivenLocation(String longitude_latitude){
		
		LOGGER.info("exploreGivenLocation() Service called ...");
		
		/*API configured along with given inputs*/
		String API_URL = APIConstant.FOURSQUARE_BASE_API_FOR_GET_FILTERED_PLACES + "&ll="
				+ longitude_latitude;

		RestTemplate restClient = new RestTemplate();
		
		/*Third party API called - Foursquare API*/
		String exploredLocation = restClient.getForObject(API_URL, String.class);
		
		LOGGER.info("exploreGivenLocation() Service response received & returned.");
		
		return exploredLocation;
		
	}
}
