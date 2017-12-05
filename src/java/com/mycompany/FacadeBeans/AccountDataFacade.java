/*
 * Created by Khoa Le on 2017.12.04  * 
 * Copyright © 2017 Khoa Le. All rights reserved. * 
 */
package com.mycompany.FacadeBeans;

import com.mycompany.EntityBeans.AccountData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author khoal
 */
@Stateless
public class AccountDataFacade extends AbstractFacade<AccountData> {

    @PersistenceContext(unitName = "AcademicSuccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountDataFacade() {
        super(AccountData.class);
    }
    
}
