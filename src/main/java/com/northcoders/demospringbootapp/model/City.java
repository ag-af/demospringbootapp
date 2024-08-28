package com.northcoders.demospringbootapp.model;

public record City(Integer id, String name, float latitude, float longitude, float elevation, String timezone, String feature_code, String country_code, String country, Integer country_id, Integer population, String[] postcodes, String admin1, String admin2, String admin3, String admin4, Integer admin1_id, Integer admin2_id, Integer admin3_id, Integer admin4_id) {
}

/*
id 	                                           Integer 	           Unique ID for this location
name 	                                       String 	           Location name. Localized following the &language= parameter, if possible
latitude, longitude                            Floating point 	   Geographical WGS84 coordinates of this location
elevation 	                                   Floating point 	   Elevation above mean sea level of this location
timezone 	                                   String 	           Time zone using time zone database definitions
feature_code 	                               String 	           Type of this location. Following the GeoNames feature_code definition
country_code 	                               String 	           2-Character FIPS country code. E.g. DE for Germany
country 	                                   String 	           Country name. Localized following the &language= parameter, if possible
country_id 	                                   Integer 	           Unique ID for this country
population          	                       Integer 	           Number of inhabitants
postcodes 	                                   String array 	   List of postcodes for this location
admin1, admin2, admin3, admin4 	               String 	           Name of hierarchical administrative areas this location resides in. Admin1 is the first administrative level. Admin2 the second administrative level. Localized following the &language= parameter, if possible
admin1_id, admin2_id, admin3_id, admin4_id 	   Integer 	           Unique IDs for the administrative areas
 */