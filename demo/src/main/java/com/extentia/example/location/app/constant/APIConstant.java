/**
 * 
 */
package com.extentia.example.location.app.constant;

/**
 * @author Pranav.Kadam
 *
 */
public class APIConstant {
	public final static String GOOGLE_API_KEY = "AIzaSyBxc0RhOK8mGNMbhZzEvw53i-z2Niawze8";
	public final static String NO_RESULT_FOUND = "Oops , No results! Please check name agian.";
	public final static String FOURSQUARE_API_CLIENT_ID = "EB5YFDTAUNPGPDNRIIQCGFH4YFQ5WWUNUMP334UTNWOTHHHO";
	public final static String FOURSQUARE_API_CLIENT_SECRET = "RPQO4BRXWA40KE1QQUV5Q001RACER4XNKANSP231X34DYU0Q";
	public final static String FOURSQUARE_API_VERSION = "20190605";
	public final static String GOOGLE_BASE_API_FOR_FIND_PLACE_FROM_TEXT = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=";
	public final static String GOOGLE_API_INPUT_FIELDS_FOR_FIND_PLACE_FROM_TEXT = "&inputtype=textquery&fields=formatted_address,name,rating,opening_hours,geometry&locationbias=ipbias&key=";
	public final static String FOURSQUARE_BASE_API_FOR_EXPLORE_LOCATION = "https://api.foursquare.com/v2/venues/explore?client_id="+FOURSQUARE_API_CLIENT_ID+"&client_secret="+FOURSQUARE_API_CLIENT_SECRET+"&v="+FOURSQUARE_API_VERSION;
	public final static String FOURSQUARE_BASE_API_FOR_GET_FILTERED_PLACES = "https://api.foursquare.com/v2/venues/search?client_id="+FOURSQUARE_API_CLIENT_ID+"&client_secret="+FOURSQUARE_API_CLIENT_SECRET+"&v="+FOURSQUARE_API_VERSION;
	public final static String GOOGLE_BASE_API_FOR_NEARBY_SEARCH = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
}
