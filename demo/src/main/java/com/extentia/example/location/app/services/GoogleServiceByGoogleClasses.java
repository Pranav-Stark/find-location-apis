/**
 * 
 */
package com.extentia.example.location.app.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.extentia.example.location.app.constant.APIConstant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.QueryAutocompleteRequest;
import com.google.maps.model.AutocompletePrediction;

/**
 * @author Pranav.Kadam
 *
 */
@Service
public class GoogleServiceByGoogleClasses extends QueryAutocompleteRequest {

	/*GeoApiContext needed to create & configure Google-API*/
	private static GeoApiContext context;

	private static final Logger LOGGER = Logger.getLogger(GoogleServiceByGoogleClasses.class.getName());
	
	

	public GoogleServiceByGoogleClasses() {
		this(context);
	}

	protected GoogleServiceByGoogleClasses(GeoApiContext context) {
		super(context);
	}

	
	/*Business logic for getAutoCompletedLocationResults() API */
	public String getAutoCompletedLocationResults(String textToComplete) {

		LOGGER.info("getAutoCompletedLocationResults() Service called ...");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		/*GeoApiContext configured with Google-API-Key & how-many-calls in case response doesn't come.*/
		context = new GeoApiContext.Builder().maxRetries(8).apiKey(APIConstant.GOOGLE_API_KEY).build();

		QueryAutocompleteRequest queryAutocompleteRequest = new GoogleServiceByGoogleClasses(context);
		
		/*Internally make a call to Google API with given input.*/
		AutocompletePrediction[] autocompletePrediction = queryAutocompleteRequest.input(textToComplete)
				.awaitIgnoreError();

		LOGGER.info("getAutoCompletedLocationResults() - Google API called and response recieved.");

		String[] predictedLocations;
		if (autocompletePrediction.length != 0) {
			int counter = 0;
			predictedLocations = new String[autocompletePrediction.length];
			
			/*Collecting given response in String array to return.*/
			for (AutocompletePrediction autocompletePrediction2 : autocompletePrediction) {
				predictedLocations[counter++] = autocompletePrediction2.description;
			}

			LOGGER.info("getAutoCompletedLocationResults() - Autocomplete location response collected and returned.");

			return gson.toJson(predictedLocations);
		}

		LOGGER.info("getAutoCompletedLocationResults() - No such a location found.");

		/*In case, no auto complete results are found.*/
		return APIConstant.NO_RESULT_FOUND;
	}
}
