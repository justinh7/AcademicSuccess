/*
 * Created by Nguyen Ha on 2017.12.07  * 
 * Copyright © 2017 Nguyen Ha. All rights reserved. * 
 */
package com.mycompany.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            images.add("photo" + i + ".jpeg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}