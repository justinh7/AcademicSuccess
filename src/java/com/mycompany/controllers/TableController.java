/*
 * Created by Hanson Cress on 2017.12.04  * 
 * Copyright © 2017 Hanson Cress. All rights reserved. * 
 */
package com.mycompany.controllers;

import com.mycompany.APIInteraction.APIDataController;
import com.mycompany.APIInteraction.BaseRate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import com.mycompany.APIInteraction.BaseRate;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/*
---------------------------------------------------------------------------
The @Named (javax.inject.Named) annotation indicates that the objects
instantiated from this class will be managed by the Contexts and Dependency
Injection (CDI) container. The name "countryController" is used within
Expression Language (EL) expressions in JSF (XHTML) facelets pages to
access the properties and invoke methods of this class.
---------------------------------------------------------------------------
 */
@Named("tableController")

/*
The @SessionScoped annotation preserves the values of the MovieController
object's instance variables across multiple HTTP request-response cycles
as long as the user's established HTTP session is alive.
 */
@SessionScoped
/**
 *
 * @author Hanson
 */
public class TableController implements Serializable {

    @Inject
    com.mycompany.APIInteraction.APIDataController adc;
    String sex = "";
    String race = "";
    String dataset = "";
    String graphType = "";
    int minYear = 2000;
    int maxYear = 2015;
    String characteristic = "total";
    
    ArrayList<Double> percentages = new ArrayList<>();
    BarGraphController BGC = new BarGraphController();
    LineGraphController LGC = new LineGraphController();
    AreaGraphController AC = new AreaGraphController();

    public void generateBar() {
        BGC.setMaxYear(maxYear);
        BGC.setMinYear(minYear);
        BGC.setPercentages(percentages);
        BGC.setGender(sex);
        BGC.setTitle(dataset);
        BGC.init();

    }
    public void generateLine()
    {
        LGC.setMaxYear(maxYear);
        LGC.setPercentages(percentages);
        LGC.setGender(sex);
        LGC.setTitle(dataset);
        LGC.init();
    }
    public void generateArea()
    {
        
    }
    

    public APIDataController getAdc() {
        return adc;
    }

    public void setAdc(APIDataController adc) {
        this.adc = adc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public void getAPIData() {
        adc.setSexFilter(sex);
        adc.setMaxYearFilter(String.valueOf(maxYear));
        adc.setMinYearFilter(String.valueOf(minYear));
        adc.setRaceFilter(race);
        adc.setCharacteristicFilter(characteristic);
        switch (dataset) {
            case "High School Dropout Rates":
                adc.highSchoolDropOutRates();
                break;
            case "College Enrollment Rates":
                adc.collegeEnrollmentRates();
                break;
            case "College Graduation Rates":
                adc.collegeGraduationRates();
                break;
            case "Rates Disconnected Youth":
                adc.ratesOfDisconnectedYouth();
                break;
            case "Labor Force Participation Rates":
                adc.laborForceParticipationRates();
                break;
            case "Imprisonment Rates":
                adc.imprisonmentRates();
                break;
        }
        List<BaseRate> data = adc.getBaseRateList();
        for(BaseRate i:data)
        {
            
            percentages.add(i.getPercentage());
            
        }
        selectGraphType();
        
                
        
    }

    public void selectGraphType() {
        switch (graphType) {
            case "bar":
                generateBar();
                break;
            case "line":
                //getBarModel();
                break;
            case "Area":
                //getBarModel();
                break;

        }
    }

}
