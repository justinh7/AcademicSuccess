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
public class TableController implements Serializable{
    @Inject
    com.mycompany.APIInteraction.APIDataController adc;
    String sex = "";
    String race = "";
    String dataset = "";

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
    int minYear = 2000;
    int maxYear = 2015;
    public void setWhichGraph()
    {
    switch(dataset)
    {
        case "highschool":
        adc.highSchoolDropOutRates();
        break;
        case "":
            adc.highSchoolDropOutRates();
        break;
        case " ":
            adc.highSchoolDropOutRates();
        break;
        case "    ":
            adc.highSchoolDropOutRates();
        break;
        case "  ":
            adc.highSchoolDropOutRates();
        break;
        case "   ":
            adc.highSchoolDropOutRates();
        break;        
    }
    }
    
    
    
    private BarChartModel barModel;
    
    // Maximum Y axis value of Total Area (in thousands) or Population (in millions)
    Integer maxAreaOrPopulation;
    
    /*
    The @Inject annotation directs the storage (injection) of the object 
    reference of the CDI container-managed PickListController bean into the 
    instance variable pickListController below after it is instantiated at runtime.
     */
    @Inject
    PickListController pickListController;

       


    // Getter method for barModel
    public BarChartModel getBarModel() {
        createBarModel();
        return barModel;
    }

    // This method initializes the Bar Chart
    private BarChartModel initBarModel() {
         List<BaseRate> list = adc.getBaseRateList();
        //total all total rates
         BarChartModel model = new BarChartModel();
        
        // Initialize maxAreaOrPopulation every time the chart to be created
        maxAreaOrPopulation = 1;

         

        
        return model;
    }

    // This method creates the Bar Chart
    private void createBarModel() {
        
        barModel = initBarModel();

        barModel.setTitle("Country Bar Chart");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Country Name");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total Area / Population");
        
        yAxis.setMin(0);
        yAxis.setMax(maxAreaOrPopulation);
    }

    
    
    
}
