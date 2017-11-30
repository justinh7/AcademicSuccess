/*
 * Created by Khoa Le on 2017.11.30  * 
 * Copyright © 2017 Khoa Le. All rights reserved. * 
 */
package com.mycompany.FacadeBeans;

import com.mycompany.EntityBeans.UserPhoto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author khoal
 */
@Stateless
public class UserPhotoFacade extends AbstractFacade<UserPhoto> {

    @PersistenceContext(unitName = "AcademicSuccessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPhotoFacade() {
        super(UserPhoto.class);
    }
    
    /*
    ====================================================
    The following method is added to the generated code.
    ====================================================
     */
    /**
     * @param userID is the Primary Key of the User entity in a table row in the CloudDriveDB database.
     * @return a list of photos associated with the User whose primary key is userID
     */
    public List<UserPhoto> findPhotosByUserID(Integer userID) {

        return (List<UserPhoto>) em.createNamedQuery("UserPhoto.findPhotosByUserID")
                .setParameter("userId", userID)
                .getResultList();
    }

    /* The following methods are inherited from the parent AbstractFacade class:
    
        create
        edit
        find
        findAll
        remove
     */
    
}
