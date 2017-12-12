

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
    String title = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     String gender3 = "";

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
        type.setFill(true);
        type.setLabel("Data Selection 1");
        if (!percentages.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages.size(); i++) {
                type.set(String.valueOf(i), percentages.get(i - minYear));
            }
        }
        areaModel.addSeries(type);
        
        type2.setFill(true);
        type2.setLabel("Data Selection 1");
        if (!percentages2.isEmpty()) {
            for (int i = minYear; i <= maxYear && (i - minYear) < percentages2.size(); i++) {
                type2.set(String.valueOf(i), percentages2.get(i - minYear));
            }
        }
        areaModel.addSeries(type2);
        
        
        type3.setFill(true);
        type3.setLabel("Data Selection 1");
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