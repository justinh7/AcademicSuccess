package com.mycompany.controllers;

import com.mycompany.EntityBeans.AccountData;
import com.mycompany.controllers.util.JsfUtil;
import com.mycompany.controllers.util.JsfUtil.PersistAction;
import com.mycompany.FacadeBeans.AccountDataFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("accountDataController")
@SessionScoped
public class AccountDataController implements Serializable {

    @Inject
    TableController tableController;
    
    @EJB
    private com.mycompany.FacadeBeans.AccountDataFacade ejbFacade;
    private List<AccountData> items = null;
    private AccountData selected;

    public AccountDataController() {
    }

    public AccountData getSelected() {
        return selected;
    }

    public void setSelected(AccountData selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AccountDataFacade getFacade() {
        return ejbFacade;
    }

    public AccountData prepareCreate() {
        selected = new AccountData();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AccountDataCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AccountDataUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AccountDataDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AccountData> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                }
                else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            }
            catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                }
                else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            }
            catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public AccountData getAccountData(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<AccountData> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AccountData> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AccountData.class)
    public static class AccountDataControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AccountDataController controller = (AccountDataController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "accountDataController");
            return controller.getAccountData(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AccountData) {
                AccountData o = (AccountData) object;
                return getStringKey(o.getId());
            }
            else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AccountData.class.getName()});
                return null;
            }
        }

    }
    
    public String show() {
        String[] sexString = selected.getSexFilter().split(" & ");
        String[] raceString = selected.getRaceFilter().split(" & ");
        String[] dataString = selected.getDataset().split(" & ");
        tableController.setTitle(selected.getTitle());        
        tableController.setGraphType(selected.getGraphType());
        tableController.setMinYear(Integer.parseInt(selected.getMinYear()));
        tableController.setMaxYear(Integer.parseInt(selected.getMaxYear()));
        
        tableController.setDataset(dataString[0]);
        tableController.setRace(raceString[0]);
        tableController.setSex(sexString[0]);
        tableController.setShowDataset1(true);
        tableController.setShowDataset2(false);
        tableController.setShowDataset3(false);
        if (dataString.length >= 1) {
            tableController.setDataset2(dataString[1]);
            tableController.setRace2(raceString[1]);
            tableController.setSex2(sexString[1]);
            tableController.setShowDataset2(true);
        }
        
        if (dataString.length == 3) {
            tableController.setDataset3(dataString[2]);     
            tableController.setRace3(raceString[2]);
            tableController.setSex3(sexString[2]);
            tableController.setShowDataset3(true);
        }
        tableController.getAPIData();
        return "AcademicGraph?faces-redirect=true";
    }

}
