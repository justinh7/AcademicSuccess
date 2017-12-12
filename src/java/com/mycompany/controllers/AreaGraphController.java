package com.mycompany.controllers;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class AreaGraphController implements Serializable {

    private LineChartModel areaModel;
    ArrayList<Double> percentages;
    ArrayList<Double> percentages2;
    ArrayList<Double> percentages3;
    int minYear = 2000;
    int maxYear = 2014;
    String gender = "";
    String gender2 = "";
    String gender3 = "";
    String race = "";
    String race2 = "";
    String race3 = "";

    String dataset = "";
    String dataset2 = "";
    String dataset3 = "";

    String title = "";

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
        createAreaModel();
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    private void createAreaModel() {
        areaModel = new LineChartModel();

        LineChartSeries type = new LineChartSeries();
        LineChartSeries type2 = new LineChartSeries();

        LineChartSeries type3 = new LineChartSeries();
        
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
        
        type.setFill(true);
        type.setLabel(label1);
        if (!percentages.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages.size(); i++) {
                type.set(String.valueOf(i), percentages.get(i - minYear));
            }
        }
        areaModel.addSeries(type);

        type2.setFill(true);
        type2.setLabel(label2);
        if (!percentages2.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages2.size(); i++) {
                type2.set(String.valueOf(i), percentages2.get(i - minYear));
            }
        }
        areaModel.addSeries(type2);

        type3.setFill(true);
        type3.setLabel(label3);
        if (!percentages3.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages3.size(); i++) {
                type3.set(String.valueOf(i), percentages3.get(i - minYear));
            }
        }
        areaModel.addSeries(type3);

        areaModel.setTitle(title);
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Percentages");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

}
