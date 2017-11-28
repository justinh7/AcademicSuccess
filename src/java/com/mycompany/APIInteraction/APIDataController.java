/*
 * Created by Osman Balci on 2017.11.28  * 
 * Copyright © 2017 Justin Hoelscher. All rights reserved. * 
 */
package com.mycompany.APIInteraction;

import java.util.List;

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
    
    String urlHighSchoolDropoutRates = "https://api.ed.gov/data/mbk-highschool-dropout";
    String urlCollegeEnrollmentRates = "https://api.ed.gov/data/mbk-college-enrollment";
    String urlCollegeGraduationRates = "https://api.ed.gov/data/mbk-bachelors-or-higher";
}
