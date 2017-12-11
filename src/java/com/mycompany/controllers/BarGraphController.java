/*
 * Created by Hanson Cress on 2017.11.28  * 
 * Copyright © 2017 Hanson Cress. All rights reserved. * 
 */
package com.mycompany.controllers;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
/**
 *
 * @author Hanson
 */
public class BarGraphController implements Serializable {
 
    private BarChartModel barModel;
    //private HorizontalBarChartModel horizontalBarModel;

        String title = "";
    
    
    ArrayList<Double> percentages;
    int minYear= 2000;
    int maxYear = 2014;
    String gender = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

  

    public ArrayList<Double> getPercentages() {
        return percentages;
    }

    public void setPercentages(ArrayList<Double> percentages) {
        this.percentages = percentages;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     /*
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 */
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries type = new ChartSeries();
        type.setLabel("Data Selection 1");
        for(int i = minYear;i<=maxYear;i++)
        {
            type.set(String.valueOf(i),percentages.get(i - minYear));
        }
        model.addSeries(type);
       
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        //createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle(title);
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Year");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Percentage");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
    /*
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries type = new ChartSeries();
        type.setLabel("Boys");
        type.set("2004", 50);
        type.set("2005", 96);
        type.set("2006", 44);
        type.set("2007", 55);
        type.set("2008", 25);
 
        ChartSeries type2 = new ChartSeries();
        type2.setLabel("Girls");
        type2.set("2004", 52);
        type2.set("2005", 60);
        type2.set("2006", 82);
        type2.set("2007", 35);
        type2.set("2008", 120);
 
        horizontalBarModel.addSeries(type);
        horizontalBarModel.addSeries(type2);
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");        
    }
 */
}


