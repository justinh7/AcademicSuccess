/*
 * Created by Hanson Cress on 2017.11.28  * 
 * Copyright © 2017 Hanson Cress. All rights reserved. * 
 */
package com.mycompany.controllers;
import javax.annotation.PostConstruct;
import java.io.Serializable;
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
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries type = new ChartSeries();
        type.setLabel("Boys");
        type.set("2004", 120);
        type.set("2005", 100);
        type.set("2006", 44);
        type.set("2007", 150);
        type.set("2008", 25);
 
        ChartSeries type2 = new ChartSeries();
        type2.setLabel("Girls");
        type2.set("2004", 52);
        type2.set("2005", 60);
        type2.set("2006", 110);
        type2.set("2007", 135);
        type2.set("2008", 120);
 
        model.addSeries(type);
        model.addSeries(type2);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
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
 
}


