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
import org.primefaces.model.chart.LineChartModel;

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

    com.mycompany.APIInteraction.APIDataController adc = new APIDataController();

    com.mycompany.APIInteraction.APIDataController adc2 = new APIDataController();

    com.mycompany.APIInteraction.APIDataController adc3 = new APIDataController();
    ;
    String race = "All";
    String sex = "All";
    String dataset = "High School Dropout Rates";
    String graphType = "";

    String sex2 = "All";
    String race2 = "All";
    String dataset2 = "High School Dropout Rates";
    String sex3 = "All";
    String race3 = "All";
    String dataset3 = "High School Dropout Rates";

    int minYear = 2000;
    int maxYear = 2014;
    String characteristic = "total";

    ArrayList<Double> percentages = new ArrayList<>();
    ArrayList<Double> percentages2 = new ArrayList<>();
    ArrayList<Double> percentages3 = new ArrayList<>();
    BarGraphController BGC = new BarGraphController();
    LineGraphController LGC = new LineGraphController();
    AreaGraphController AC = new AreaGraphController();

    BarChartModel barModel;
    LineChartModel lineModel;
    LineChartModel areaModel;

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public String getRace2() {
        return race2;
    }

    public void setRace2(String race2) {
        this.race2 = race2;
    }

    public String getDataset2() {
        return dataset2;
    }

    public void setDataset2(String dataset2) {
        this.dataset2 = dataset2;
    }

    public String getSex3() {
        return sex3;
    }

    public void setSex3(String sex3) {
        this.sex3 = sex3;
    }

    public String getRace3() {
        return race3;
    }

    public void setRace3(String race3) {
        this.race3 = race3;
    }

    public String getDataset3() {
        return dataset3;
    }

    public void setDataset3(String dataset3) {
        this.dataset3 = dataset3;
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(LineChartModel areaModel) {
        this.areaModel = areaModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public String getGraphType() {
        return graphType;
    }

    public void setGraphType(String graphType) {
        this.graphType = graphType;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public void generateBar() {
        //getAPIData();
        BGC.setMaxYear(maxYear);
        BGC.setMinYear(minYear);
        BGC.setPercentages(percentages);
        BGC.setGender(sex);
        BGC.setRace(race);
        BGC.setDataset(dataset);
        BGC.setPercentages2(percentages2);
        BGC.setGender2(sex2);
        BGC.setRace2(race2);
        BGC.setDataset2(dataset2);
        BGC.setPercentages3(percentages3);
        BGC.setGender3(sex3);
        BGC.setRace3(race3);
        BGC.setDataset3(dataset3);
        BGC.setTitle(dataset + " vs. " + dataset2 + " vs. " + dataset3);
        BGC.init();
        barModel = BGC.getBarModel();

    }

    public void generateLine() {
        LGC.setMinYear(minYear);
        LGC.setMaxYear(maxYear);
        LGC.setPercentages(percentages);
        LGC.setGender(sex);
        LGC.setRace(race);
        LGC.setDataset(dataset);
        LGC.setPercentages2(percentages2);
        LGC.setGender2(sex2);
        LGC.setRace2(race2);
        LGC.setDataset2(dataset2);
        LGC.setPercentages3(percentages3);
        LGC.setGender3(sex3);
        LGC.setRace3(race3);
        LGC.setDataset3(dataset3);
        LGC.setTitle(dataset + " vs. " + dataset2 + " vs. " + dataset3);
        LGC.init();
        lineModel = LGC.getLineModel1();
    }

    public void generateArea() {
        AC.setMinYear(minYear);
        AC.setMaxYear(maxYear);
        AC.setPercentages(percentages);
        AC.setGender(sex);
        AC.setRace(race);
        AC.setDataset(dataset);
        AC.setPercentages2(percentages2);
        AC.setGender2(sex2);
        AC.setRace2(race2);
        AC.setDataset2(dataset2);
        AC.setPercentages3(percentages3);
        AC.setGender3(sex3);
        AC.setRace3(race3);
        AC.setDataset3(dataset3);
        AC.setTitle(dataset + " vs. " + dataset2 + " vs. " + dataset3);
        AC.init();
        areaModel = AC.getAreaModel();
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
        //adc.setSexFilter(sex);
        adc.setMaxYearFilter(String.valueOf(maxYear));
        adc.setMinYearFilter(String.valueOf(minYear));
        adc2.setMaxYearFilter(String.valueOf(maxYear));
        adc2.setMinYearFilter(String.valueOf(minYear));
        adc3.setMaxYearFilter(String.valueOf(maxYear));
        adc3.setMinYearFilter(String.valueOf(minYear));
        //adc.setRaceFilter(race);
        //adc.setCharacteristicFilter(characteristic);
        adc.setCharacteristicFilter(buildCharacteristicString(sex, race, dataset));
        adc2.setCharacteristicFilter(buildCharacteristicString(sex2, race2, dataset2));
        adc3.setCharacteristicFilter(buildCharacteristicString(sex3, race3, dataset3));

        switch (dataset) {
            case "High School Dropout Rates":
                adc.highSchoolDropOutRates();
                break;
            case "College Enrollment Rates":

                System.out.println("COLLEGE ENROLLEMENT RATES");
                adc.collegeEnrollmentRates();
                break;
            case "College Graduation Rates":
                System.out.println("COLLEGE Graduation RATES");
                adc.collegeGraduationRates();
                break;
            case "Rates Disconnected Youth":
                System.out.println("Disconnected YOUTH RATES");
                adc.ratesOfDisconnectedYouth();
                break;
            case "Labor Force Participation Rates":
                System.out.println("LABOR FORCE RATES");
                adc.laborForceParticipationRates();
                break;
            case "Imprisonment Rates":
                adc.imprisonmentRates();
                break;
        }
        switch (dataset2) {
            case "High School Dropout Rates":
                adc2.highSchoolDropOutRates();
                break;
            case "College Enrollment Rates":

                System.out.println("COLLEGE ENROLLEMENT RATES");
                adc2.collegeEnrollmentRates();
                break;
            case "College Graduation Rates":
                System.out.println("COLLEGE Graduation RATES");
                adc2.collegeGraduationRates();
                break;
            case "Rates Disconnected Youth":
                System.out.println("Disconnected YOUTH RATES");
                adc2.ratesOfDisconnectedYouth();
                break;
            case "Labor Force Participation Rates":
                System.out.println("LABOR FORCE RATES");
                adc2.laborForceParticipationRates();
                break;
            case "Imprisonment Rates":
                adc2.imprisonmentRates();
                break;
        }
        switch (dataset3) {
            case "High School Dropout Rates":
                adc3.highSchoolDropOutRates();
                break;
            case "College Enrollment Rates":

                System.out.println("COLLEGE ENROLLEMENT RATES");
                adc3.collegeEnrollmentRates();
                break;
            case "College Graduation Rates":
                System.out.println("COLLEGE Graduation RATES");
                adc3.collegeGraduationRates();
                break;
            case "Rates Disconnected Youth":
                System.out.println("Disconnected YOUTH RATES");
                adc3.ratesOfDisconnectedYouth();
                break;
            case "Labor Force Participation Rates":
                System.out.println("LABOR FORCE RATES");
                adc3.laborForceParticipationRates();
                break;
            case "Imprisonment Rates":
                adc3.imprisonmentRates();
                break;
        }
        percentages.clear();
        percentages2.clear();
        percentages3.clear();
        
        List<BaseRate> data = adc.getBaseRateList();
        List<BaseRate> data2 = adc2.getBaseRateList();
        List<BaseRate> data3 = adc3.getBaseRateList();
        for (BaseRate i : data) {

            percentages.add(i.getPercentage());
        }
        for (BaseRate i : data2) {

            percentages2.add(i.getPercentage());

        }
        for (BaseRate i : data3) {

            percentages3.add(i.getPercentage());

        }
        selectGraphType();

    }

    public void selectGraphType() {
        switch (graphType) {
            case "Bar Graph":
                barModel = null;
                lineModel = null;
                areaModel = null;
                generateBar();
                areaModel = null;
                lineModel = null;
                break;
            case "Line Graph":
                barModel = null;
                lineModel = null;
                areaModel = null;
                generateLine();
                barModel = null;
                areaModel = null;
                break;
            case "Area Graph":
                barModel = null;
                lineModel = null;
                areaModel = null;
                generateArea();
                barModel = null;
                lineModel = null;
                break;

        }
    }

    private String buildCharacteristicString(String sex, String race, String dataset) {
        StringBuilder result = new StringBuilder();
        race.replaceAll(" ", "%20");

        //Filtering for dataset 1
        if (dataset.equals("High School Dropout Rates") || dataset.equals("College Graduation Rates")) {
            if (sex.equals("All") && race.equals("All")) {
                result.append("Total");
            } else if (race.equals("All")) {
                result.append("Total%20-%20");
                result.append(sex);
            } else if (sex.equals("All")) {
                result.append("Total%20-%20");
                result.append(race);
            } else {
                result.append("Total%20-%20");
                result.append(sex);
                result.append("s,%20");
                result.append(race);
            }
        } else if (dataset.equals("College Enrollment Rates")) {
            if (sex.equals("All") && race.equals("All")) {
                result.append("Total%20");
            } else if (race.equals("All")) {
                result.append("Total%20-%20");
                result.append(sex);
            } else if (sex.equals("All")) {
                result.append("Total%20-%20");
                result.append(race);
            } else {
                result.append("Total%20-%20");
                result.append(sex);
                result.append(",%20");
                result.append(race);
            }
        } else if (dataset.equals("Rates Disconnected Youth")) {
            if (sex.equals("All") && race.equals("All")) {
                result.append("Total");
            } else if (race.equals("All")) {
                result.append("Total%20-%20");
                result.append(sex);
            } else if (sex.equals("All")) {
                result.append("Total%20-%20");
                result.append(race);
            } else {
                if (sex.equals("Female")) {
                    result.append("Total%20-%20");
                    result.append(sex);
                    result.append(",");
                    result.append(race);
                } else if (sex.equals("Male")) {
                    result.append("Total%20-%20");
                    result.append(sex);
                    result.append(",%20");
                    result.append(race);
                }
            }

        } else if (dataset.equals("Imprisonment Rates")) {
            if (sex.equals("All") && race.equals("All")) {
                result.append("Total");
            } else if (race.equals("All")) {
                result.append("Total%20-%20");
                result.append(sex);
            } else if (sex.equals("All")) {
                result.append("Total%20-%20");
                if (race.equals("White,%20non-Hispanic") || race.equals("Black,%20non-Hispanic") || race.equals("Hispanic")) {
                    result.append(race);
                } else {
                    result.append("Other%20race,%20non-Hispanic");
                }
            } else {
                result.append("Total%20-%20");
                if (race.equals("White,%20non-Hispanic") || race.equals("Black,%20non-Hispanic") || race.equals("Hispanic")) {
                    result.append(race);
                } else {
                    result.append("Other%20race,%20non-Hispanic");
                }
            }

        } else if (dataset.equals("Labor Force Participation Rates")) {
            if (sex.equals("All") && race.equals("All")) {
                result.append("Total");
            } else if (race.equals("All")) {
                result.append("Total%20-%20");
                result.append(sex);
                result.append(",%20Age%2018-24");
            } else if (sex.equals("All")) {
                result.append("Total%20-%20");
                result.append("Male,%20");
                if (race.equals("White,%20non-Hispanic")) {
                    result.append("White");
                } else if (race.equals("Black,%20non-Hispanic")) {
                    result.append("Black");
                } else if (race.equals("Hispanic")) {
                    result.append("Hispanic");
                } else if (race.equals("Asian,%20non-Hispanic")) {
                    result.append("Asian");
                }

                result.append(",%20Age%2018-24");
            } else {
                result.append("Total%20-%20");
                result.append(sex);
                result.append(",%20");
                if (race.equals("White,%20non-Hispanic")) {
                    result.append("White");
                } else if (race.equals("Black,%20non-Hispanic")) {
                    result.append("Black");
                } else if (race.equals("Hispanic")) {
                    result.append("Hispanic");
                } else if (race.equals("Asian, %20non-Hispanic")) {
                    result.append("Asian");
                }
                result.append(",%20Age%2018-24");

            }
        }

        return result.toString();
    }

}
