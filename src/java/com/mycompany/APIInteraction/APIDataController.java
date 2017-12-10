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
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.OutputStream; 

/**
 *
 * @author Justin
 */
@Named(value = "apiDataController")
@SessionScoped
public class APIDataController implements Serializable {

    private List<BaseRate> baseRateList;

    String apiKey = "01YNnqMQGsdwOSSRpoVUSgY4At2lMDvoled038Gc";

    private final String urlHighSchoolDropoutRates = "https://api.ed.gov/data/mbk-highschool-dropout";
    private final String urlCollegeEnrollmentRates = "https://api.ed.gov/data/mbk-college-enrollment";
    private final String urlCollegeGraduationRates = "https://api.ed.gov/data/mbk-bachelors-or-higher";
    private final String urlRatesOfDisconnectedYouth = "https://api.ed.gov/data/mbk-disconnected-youth";
    private final String urlLaborForceParticipationRates = "https://api.ed.gov/data/mbk-labor-force-participation";
    private final String urlImprisonmentRates = "https://api.ed.gov/data/mbk-imprisonment";

    private String statusMessage = "";

    private String characteristicFilter;
    private String raceFilter;
    private String sexFilter;
    private String minYearFilter;
    private String maxYearFilter;

    public List<BaseRate> getBaseRateList() {
        return baseRateList;
    }

    public void setBaseRateList(List<BaseRate> baseRateList) {
        this.baseRateList = baseRateList;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getCharacteristicFilter() {
        return characteristicFilter;
    }

    public void setCharacteristicFilter(String characteristicFilter) {
        this.characteristicFilter = characteristicFilter;
    }

    public String getRaceFilter() {
        return raceFilter;
    }

    public void setRaceFilter(String raceFilter) {
        this.raceFilter = raceFilter;
    }

    public String getSexFilter() {
        return sexFilter;
    }

    public void setSexFilter(String sexFilter) {
        this.sexFilter = sexFilter;
    }

    public String getMinYearFilter() {
        return minYearFilter;
    }

    public void setMinYearFilter(String minYearFilter) {
        this.minYearFilter = minYearFilter;
    }

    public String getMaxYearFilter() {
        return maxYearFilter;
    }

    public void setMaxYearFilter(String maxYearFilter) {
        this.maxYearFilter = maxYearFilter;
    }
        

    public void highSchoolDropOutRates() {

        statusMessage = "";
        getDataHelper(urlHighSchoolDropoutRates);
    }
    
    public void collegeEnrollmentRates() {
        statusMessage = "";
        getDataHelper(urlCollegeEnrollmentRates);
    }
    
    public void collegeGraduationRates() {
        statusMessage = "";
        getDataHelper(urlCollegeGraduationRates);
    }
    
    public void ratesOfDisconnectedYouth() {
        statusMessage = "";
        getDataHelper(urlRatesOfDisconnectedYouth);
    }
    
    public void laborForceParticipationRates() {
        statusMessage = "";
        getDataHelper(urlLaborForceParticipationRates);
    }
    
    public void imprisonmentRates() {
        statusMessage = "";
        getDataHelper(urlImprisonmentRates);
    }
    
    

    private void getDataHelper(String baseUrl) {
        JSONArray jsonArray;
        baseRateList = new ArrayList<>();
        
        String raceTitle = "Race%2fethnicity";
        String sexTitle = "Sex";
        if (baseUrl.equals(urlHighSchoolDropoutRates)) {
            raceTitle = "Race%2fEthnicity%20";
        }
        else if (baseUrl.equals(urlRatesOfDisconnectedYouth)) {
            raceTitle = "Race%2fethnicity%20";
            sexTitle = "Sex ";
        }
        
        //Trial Filters
        //characteristicFilter = "Total";
        minYearFilter = "2002";
        maxYearFilter = "2008";
        sexFilter = "Males";
        raceFilter = "Hispanic";
        
        try {
            for (int pageNumber = 1; pageNumber < 2; pageNumber++) {

                String requestUrl = baseUrl + "?api_key=" + apiKey + "&per_page=1000&page=" + pageNumber;
                
                if (characteristicFilter != null && !characteristicFilter.equals("")) {
                    requestUrl += "&Characteristic=" + characteristicFilter;
                }
                
                if (raceFilter != null && !raceFilter.equals("")) {
                    requestUrl += "&" + raceTitle + "=" + raceFilter;
                }
                
                if (sexFilter != null && !sexFilter.equals("")) {
                    requestUrl += "&" + sexTitle + "=" + sexFilter;
                }
                
                if (minYearFilter != null && !minYearFilter.equals("") && maxYearFilter != null && !maxYearFilter.equals("")) {
                    for (int year = Integer.parseInt(minYearFilter); year <= Integer.parseInt(maxYearFilter); year++){
                        requestUrl += "&Year=" + year;
                    }
                    
                }

                // Obtain the JSON file containing the movie search results at the given page number
                String jsonData = readUrlContent(requestUrl);

                // The returned JSON data comes as a dictionary. Enclose it within an array.
                jsonData = "[" + jsonData + "]";

                // Instantiate a JSON Array object from the JSON data obtained as an array
                jsonArray = new JSONArray(jsonData);

                /*
                jsonArray.getJSONObject(0), object at index 0, gives the dictionary returned in the JSON file.
                getJSONArray("results") gets the list of movies given under the KEY "results" of the dictionary.
                 */
                JSONArray jsonArrayResources = jsonArray.getJSONObject(0).getJSONArray("resources");

                int index = 0;

                if (jsonArrayResources.length() > index) {

                    while (jsonArrayResources.length() > index) {

                        // Get the JSONObject at index
                        JSONObject jsonObject = jsonArrayResources.getJSONObject(index);

                        String characteristic = jsonObject.optString("Characteristic", "");
                        String count = jsonObject.optString("Count", "");
                        String percentage;
                        if (baseUrl == null ? urlImprisonmentRates == null : baseUrl.equals(urlImprisonmentRates)) {
                            String ratePerHundredThousand = jsonObject.optString("Rate per 100,000", "");
                            percentage = Integer.parseInt(ratePerHundredThousand) / 100000.00 + "";
                        } else {
                            percentage = jsonObject.optString("Percentage", "");
                        }

                        String race = jsonObject.optString("Race/Ethnicity", "");
                        String sex = jsonObject.optString("Sex", "");
                        String year = jsonObject.optString("Year", "");

                        double countAsDouble = Double.parseDouble(count);
                        double percentageAsDouble = Double.parseDouble(percentage);
                        int yearAsInt = Integer.parseInt(year);

                        BaseRate rate
                                = new BaseRate(characteristic, countAsDouble, percentageAsDouble, race, sex, yearAsInt);

                        baseRateList.add(rate);
                        index++;

                    }

                } else {
                    // Take no action since there are no search results at this page number
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String readUrlContent(String webServiceURL) throws Exception {

        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }
            }
        };

// Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            System.out.println(e);
        }


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
