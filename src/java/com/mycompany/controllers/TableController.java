/*
 * Created by Hanson Cress on 2017.12.04  * 
 * Copyright © 2017 Hanson Cress. All rights reserved. * 
 */
package com.mycompany.controllers;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

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
    
    
    
    
}
