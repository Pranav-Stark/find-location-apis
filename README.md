# find-location-apis.

Java project is developed using Spring-boot.

In this , there are five APIs in total to find desired result as follows.

1. Get Auto Completed Locations
http://localhost:8081/location/apis/v1/getAutoCompletedLocations?location= <location-to-search> ex.location-to-search = Pun for Pune etc
  
2. Get Location (Passing text)
http://localhost:8081/location/apis/v1/getSearchedLocation?location= <location-to-search> ex.location-to-search = Pune

3. Get Near By Locations
http://localhost:8081/location/apis/v1/getNearByLocations?keyword=<keyword>&longitude_latitude=<longitude,latitude>&radius=<radius>&type=<type>
  ex.keyword=bank (anything specific) , longitude_latitude = 18.5204,73.8567 ,type = bank/movie_theater/airport ,radius= 1000 (in meter max 50000)

4. Get Filtered Location On Category
http://localhost:8081/location/apis/v1/getFilteredLocationOnCategory?categoryId=<category-Id>&longitude_latitude=<longitude,latitude> ex.categoryId = 4bf58dd8d48988d17f941735 (Movie Theater) , longitude_latitude - 18.5204,73.8567

5. Get Explored (Detailed) Location
http://localhost:8081/location/apis/v1/getExploredLocation?longitude_latitude=<longitude,latitude> ex.longitude_latitude = 18.5204,73.8567

 To achive this , I am using third party APIs like Google and Foursquare.

# Project includes following additional points as well.

1. Swagger implementation. (For better documentation)
http://localhost:8081/swagger-ui.html#/
   - By hitting Swagger link , you will get better idea of the APIs and there required parameteres as well as produced outputs.
   
2. Controller - Service layer architecture.

3. RestTemplate to make API calls

4. Test-cases driven. (Using JUnit and Mockito)

5. Logger




