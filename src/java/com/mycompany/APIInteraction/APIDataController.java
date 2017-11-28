/*
 * Created by Osman Balci on 2017.11.28  * 
 * Copyright © 2017 Justin Hoelscher. All rights reserved. * 
 */
package com.mycompany.APIInteraction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.primefaces.util.ArrayUtils;

/**
 *
 * @author Justin
 */
public class APIDataController {
    
    private List<CollegeEnrollmentRate> collegeEnrollmentRates;
    private List<CollegeGraduationRate> collegeGraduationRates;
    private List<HighSchoolDropOutRate> highSchoolDropOutRates;
    private List<ImprisonmentRate> imprisonmentRates;
    private List<LaborForceParticipationRate> laborForceParticipationRates;
    private List<RateOfDisconnectedYouth> ratesOfDisconnectedYouth;
    
    String apiKey = "01YNnqMQGsdwOSSRpoVUSgY4At2lMDvoled038Gc";
    
    private final String urlHighSchoolDropoutRates = "https://api.ed.gov/data/mbk-highschool-dropout";
    private final String urlCollegeEnrollmentRates = "https://api.ed.gov/data/mbk-college-enrollment";
    private final String urlCollegeGraduationRates = "https://api.ed.gov/data/mbk-bachelors-or-higher";
    private final String urlRatesOfDisconnectedYouth = "https://api.ed.gov/data/mbk-disconnected-youth";
    private final String urlLaborForceParticipationRates = "https://api.ed.gov/data/mbk-labor-force-participation";
    private final String urlImprisonmentRates = "https://api.ed.gov/data/mbk-imprisonment";
    
    private String statusMessage = "";
    
    
    public String getHighSchoolDropOutRates() {

        statusMessage = "";

        JSONArray jsonArray;
        highSchoolDropOutRates = new ArrayList<HighSchoolDropOutRate>();
        
        
        
        try {
            for (int pageNumber = 1; pageNumber < 3; pageNumber++) {


                String tmdbMovieSearchWebServiceUrl = "";

                // Obtain the JSON file containing the movie search results at the given page number
                String movieSearchResultsJsonData = readUrlContent(tmdbMovieSearchWebServiceUrl);

                // The returned JSON data comes as a dictionary. Enclose it within an array.
                movieSearchResultsJsonData = "[" + movieSearchResultsJsonData + "]";

                // Instantiate a JSON Array object from the JSON data obtained as an array
                jsonArray = new JSONArray(movieSearchResultsJsonData);

                /*
                jsonArray.getJSONObject(0), object at index 0, gives the dictionary returned in the JSON file.
                getJSONArray("results") gets the list of movies given under the KEY "results" of the dictionary.
                 */
                JSONArray jsonArrayFoundMovies = jsonArray.getJSONObject(0).getJSONArray("results");

                int index = 0;

                if (jsonArrayFoundMovies.length() > index) {

                    while (jsonArrayFoundMovies.length() > index) {

                        // Get the JSONObject at index
                        JSONObject jsonObject = jsonArrayFoundMovies.getJSONObject(index);

                        /*
                        ======== JSON Data Optional Processing ======== 
                        
                        optBoolean(String key, boolean defaultValue) 
                            Obtain the Boolean value for the given "key" if a value exists; otherwise, use the defaultValue.
                        
                        optDouble(String key, double defaultValue) 
                            Obtain the Double value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.

                        optInt(String key, int defaultValue) 
                            Obtain the Int value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.
          
                        optLong(String key, long defaultValue) 
                            Obtain the Long value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.
                        
                        optString(String key, String defaultValue) 
                            Obtain the String value for the given "key" if a value exists; otherwise, use the defaultValue.
                        
                        ============================
                        Movie Poster Image File Name
                        ============================
                         */
                        String posterFileName = jsonObject.optString("poster_path", "");
                        if (posterFileName.equals("")) {
                            // Skip the movie with no poster image provided
                            index++;
                            continue;
                        }

                        /*
                        =========================
                        Movie Overview (Synopsis)
                        =========================
                         */
                        String overview = jsonObject.optString("overview", "");
                        if (overview.equals("")) {
                            overview = "No movie overview is provided!";
                        }

                        /*
                        ==================
                        Movie Release Date
                        ==================
                         */
                        String releaseDate = jsonObject.optString("release_date", "");
                        if (releaseDate.equals("")) {
                            releaseDate = "No Release Date";
                        }



                        

                        /*
                        ================================================================
                        Create a new SearchedMovie object dressed up with its Attributes
                        ================================================================
                         */
                        
                        index++;
                        
                    }

                } else {
                    // Take no action since there are no search results at this page number
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return "MovieSearchResults?faces-redirect=true";
    }
    
    public String readUrlContent(String webServiceURL) throws Exception {
        /*
        reader is an object reference pointing to an object instantiated from the BufferedReader class.
        Currently, it is "null" pointing to nothing.
         */
        BufferedReader reader = null;

        try {
            // Create a URL object from the webServiceURL given
            URL url = new URL(webServiceURL);
            /*
            The BufferedReader class reads text from a character-input stream, buffering characters
            so as to provide for the efficient reading of characters, arrays, and lines.
             */
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            // Create a mutable sequence of characters and store its object reference into buffer
            StringBuilder buffer = new StringBuilder();

            // Create an array of characters of size 10240
            char[] chars = new char[10240];

            int numberOfCharactersRead;
            /*
            The read(chars) method of the reader object instantiated from the BufferedReader class
            reads 10240 characters as defined by "chars" into a portion of a buffered array.

            The read(chars) method attempts to read as many characters as possible by repeatedly
            invoking the read method of the underlying stream. This iterated read continues until
            one of the following conditions becomes true:

                (1) The specified number of characters have been read, thus returning the number of characters read.
                (2) The read method of the underlying stream returns -1, indicating end-of-file, or
                (3) The ready method of the underlying stream returns false, indicating that further input requests would block.

            If the first read on the underlying stream returns -1 to indicate end-of-file then the read(chars) method returns -1.
            Otherwise the read(chars) method returns the number of characters actually read.
             */
            while ((numberOfCharactersRead = reader.read(chars)) != -1) {
                buffer.append(chars, 0, numberOfCharactersRead);
            }

            // Return the String representation of the created buffer
            return buffer.toString();

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
    
    
}
