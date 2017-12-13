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
    ArrayList<Double> percentages2;
    ArrayList<Double> percentages3;

    String gender = "";
    String gender2 = "";
    String gender3 = "";
    
    String race = "";
    String race2 = "";
    String race3 = "";
    
    String dataset = "";
    String dataset2 = "";
    String dataset3 = "";

    int minYear = 2000;
    int maxYear = 2014;

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getDataset2() {
        return dataset2;
    }

    public void setDataset2(String dataset2) {
        this.dataset2 = dataset2;
    }

    public String getDataset3() {
        return dataset3;
    }

    public void setDataset3(String dataset3) {
        this.dataset3 = dataset3;
    }

    
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace2() {
        return race2;
    }

    public void setRace2(String race2) {
        this.race2 = race2;
    }

    public String getRace3() {
        return race3;
    }

    public void setRace3(String race3) {
        this.race3 = race3;
    }
    
    

    public ArrayList<Double> getPercentages2() {
        return percentages2;
    }

    public void setPercentages2(ArrayList<Double> percentages2) {
        this.percentages2 = percentages2;
    }

    public ArrayList<Double> getPercentages3() {
        return percentages3;
    }

    public void setPercentages3(ArrayList<Double> percentages3) {
        this.percentages3 = percentages3;
    }

    public String getGender3() {
        return gender3;
    }

    public void setGender3(String gender3) {
        this.gender3 = gender3;
    }

    public String getGender2() {
        return gender2;
    }

    public void setGender2(String gender2) {
        this.gender2 = gender2;
    }

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
        model.setAnimate(true);

        ChartSeries type = new ChartSeries();
        ChartSeries type2 = new ChartSeries();
        ChartSeries type3 = new ChartSeries();

        String label1 = dataset + " ";
        String label2 = dataset2 + " ";
        String label3 = dataset3 + " ";
        
        if (gender != null && !gender.equals("")) {
            label1 = label1 + gender;
            if (race != null && !race.equals("")) {
                label1 = label1 + ", " + race;
            }
        }
        else {
            label1 = label1 + race;
        }
        
        if (gender2 != null && !gender2.equals("")) {
            label2 = label2 + gender2;
            if (race2 != null && !race2.equals("")) {
                label2 = label2 + ", " + race2;
            }
        }
        else {
            label2 = label2 + race2;
        }
        
        if (gender3 != null && !gender3.equals("")) {
            label3 = label3 + gender3;
            if (race3 != null && !race3.equals("")) {
                label3 = label3 + ", " + race3;
            }
        }
        else {
            label3 = label3 + race3;
        }
        
        
        type.setLabel(label1);
        if (!percentages.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages.size(); i++) {
                type.set(String.valueOf(i), percentages.get(i - minYear));
            }
        }
        model.addSeries(type);
        type2.setLabel(label2);
        if (!percentages2.isEmpty()) {

            for (int i = minYear; i <= maxYear && (i - minYear) < percentages2.size(); i++) {
                type2.set(String.valueOf(i), percentages2.get(i - minYear));
            }
        }
        model.addSeries(type2);

        type3.setLabel(label3);
        if (!percentages3.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages3.size(); i++) {
                type3.set(String.valueOf(i), percentages3.get(i - minYear));
            }
        }
        model.addSeries(type3);

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
