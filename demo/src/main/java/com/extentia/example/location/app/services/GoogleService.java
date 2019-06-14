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
public class GoogleService {

	private static final Logger LOGGER = Logger.getLogger(GoogleService.class.getName());

	/*Business logic for findLocationFromText() API */
	public String findLocationFromText(String locationToSearch) {

		LOGGER.info("findLocationFromText() Service called ...");

		/*API configured along with given inputs*/
		String API_URL = APIConstant.GOOGLE_BASE_API_FOR_FIND_PLACE_FROM_TEXT + locationToSearch
				+ APIConstant.GOOGLE_API_INPUT_FIELDS_FOR_FIND_PLACE_FROM_TEXT + APIConstant.GOOGLE_API_KEY;

		RestTemplate restClient = new RestTemplate();
		
		/*Third party API called - Google API*/
		String googleLocationAPIResponse = restClient.getForObject(API_URL, String.class);

		LOGGER.info("findLocationFromText() Service response received & returned.");

		return googleLocationAPIResponse;
	}
	
	
	/*Business logic for findNearByLocations() API */
	public String findNearByLocations(String longitude_latitude,String radius , String type , String keyWord){
		
		LOGGER.info("findNearByLocations() Service called ...");
		
		/*API configured along with given inputs*/
		String API_URL = APIConstant.GOOGLE_BASE_API_FOR_NEARBY_SEARCH + "location=" + longitude_latitude +
		"&radius=" + radius + "&type=" + type + "&keyword="	 + keyWord + "&key=" + APIConstant.GOOGLE_API_KEY;	
		
		RestTemplate restClient = new RestTemplate();
		
		/*Third party API called - Google API*/
		String googleNearByLocationAPIResponse = restClient.getForObject(API_URL, String.class);
		
		LOGGER.info("findNearByLocations() Service response received & returned.");
		
		return googleNearByLocationAPIResponse;
	}

}
