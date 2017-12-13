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
    private String title = "";
    private ArrayList<Double> percentages;
    private ArrayList<Double> percentages2;
    private ArrayList<Double> percentages3;
    private int minYear = 2000;
    private int maxYear = 2014;
    private String gender = "";
    private String gender2 = "";
    private String gender3 = "";

    private String race = "";
    private String race2 = "";
    private String race3 = "";

    private String dataset = "";
    private String dataset2 = "";
    private String dataset3 = "";

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
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Year"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        //yAxis.setMax(100);
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
        model.setAnimate(true);

        String label1 = dataset + " ";
        String label2 = dataset2 + " ";
        String label3 = dataset3 + " ";

        if (gender != null && !gender.equals("")) {
            label1 = label1 + gender;
            if (race != null && !race.equals("")) {
                label1 = label1 + ", " + race;
            }
        } else {
            label1 = label1 + race;
        }

        if (gender2 != null && !gender2.equals("")) {
            label2 = label2 + gender2;
            if (race2 != null && !race2.equals("")) {
                label2 = label2 + ", " + race2;
            }
        } else {
            label2 = label2 + race2;
        }

        if (gender3 != null && !gender3.equals("")) {
            label3 = label3 + gender3;
            if (race3 != null && !race3.equals("")) {
                label3 = label3 + ", " + race3;
            }
        } else {
            label3 = label3 + race3;
        }

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel(label1);
        if (!percentages.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages.size(); i++) {
                series1.set(String.valueOf(i), percentages.get(i - minYear));
            }
            model.addSeries(series1);
        }

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel(label2);
        if (!percentages2.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages2.size(); i++) {
                series2.set(String.valueOf(i), percentages2.get(i - minYear));
            }
            model.addSeries(series2);
        }

        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel(label3);
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
