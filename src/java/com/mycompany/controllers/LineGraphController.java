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
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Hanson
 */
public class LineGraphController implements Serializable {

    private LineChartModel lineModel1;
    //private LineChartModel lineModel2;
    String title = "";

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

    ArrayList<Double> percentages;
    ArrayList<Double> percentages2;
    ArrayList<Double> percentages3;
    int minYear = 2000;
    int maxYear = 2014;
    String gender = "";
    String gender2 = "";

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

    public String getGender2() {
        return gender2;
    }

    public void setGender2(String gender2) {
        this.gender2 = gender2;
    }

    public String getGender3() {
        return gender3;
    }

    public void setGender3(String gender3) {
        this.gender3 = gender3;
    }
    String gender3 = "";

    @PostConstruct
    public void init() {
        createLineModels();
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    /*
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     */
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle(title);
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
        yAxis.setLabel("Percentage");

        /*lineModel2 = initCategoryModel();
        lineModel2.setTitle("Category Chart");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);*/
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Data Selection 1");
        if (!percentages.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages.size(); i++) {
                series1.set(String.valueOf(i), percentages.get(i - minYear));
            }
        }
        model.addSeries(series1);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Data Selection 2");
        if (!percentages2.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages2.size(); i++) {
                series2.set(String.valueOf(i), percentages2.get(i - minYear));
            }
        }
        model.addSeries(series2);

        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel("Data Selection 3");
        if (!percentages3.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages3.size(); i++) {
                series3.set(String.valueOf(i), percentages3.get(i - minYear));
            }
            model.addSeries(series3);
        }
        return model;
    }
    /*
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
     */
}
