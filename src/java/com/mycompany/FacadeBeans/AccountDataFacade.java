/*
 * Created by Khoa Le on 2017.12.04  * 
 * Copyright © 2017 Khoa Le. All rights reserved. * 
 */
package com.mycompany.FacadeBeans;

import com.mycompany.EntityBeans.AccountData;
import java.util.List;
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
    
    public List<AccountData> findUserFilesByUserID(Integer userID) {
        /*
        The following @NamedQuery definition is given in UserFile.java entity class file:
        @NamedQuery(name = "UserFile.findUserFilesByUserId", query = "SELECT u FROM UserFile u WHERE u.userId.id = :userId")
        
        The following statement obtaines the results from the named database query.
         */
        List<AccountData> accountDatas = em.createNamedQuery("AccountData.findAccountDataByUserId")
                .setParameter("userId", userID)
                .getResultList();

        return accountDatas;
    }
    
}
