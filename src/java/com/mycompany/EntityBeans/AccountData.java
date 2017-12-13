/*
 * Created by Khoa Le on 2017.12.04  * 
 * Copyright © 2017 Khoa Le. All rights reserved. * 
 */
package com.mycompany.EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khoal
 */
@Entity
@Table(name = "AccountData")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountData.findAll", query = "SELECT a FROM AccountData a")
    , @NamedQuery(name = "AccountData.findById", query = "SELECT a FROM AccountData a WHERE a.id = :id")
    , @NamedQuery(name = "AccountData.findByTitle", query = "SELECT a FROM AccountData a WHERE a.title = :title")
    , @NamedQuery(name = "AccountData.findByDataset", query = "SELECT a FROM AccountData a WHERE a.dataset = :dataset")
    , @NamedQuery(name = "AccountData.findByRaceFilter", query = "SELECT a FROM AccountData a WHERE a.raceFilter = :raceFilter")
    , @NamedQuery(name = "AccountData.findBySexFilter", query = "SELECT a FROM AccountData a WHERE a.sexFilter = :sexFilter")
    , @NamedQuery(name = "AccountData.findByMinYear", query = "SELECT a FROM AccountData a WHERE a.minYear = :minYear")
    , @NamedQuery(name = "AccountData.findByMaxYear", query = "SELECT a FROM AccountData a WHERE a.maxYear = :maxYear")
    , @NamedQuery(name = "AccountData.findByGraphType", query = "SELECT a FROM AccountData a WHERE a.graphType = :graphType")
    , @NamedQuery(name = "AccountData.findAccountDataByUserId", query = "SELECT u FROM AccountData u WHERE u.userId.id = :userId")
})

public class AccountData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "dataset")
    private String dataset;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "race_filter")
    private String raceFilter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "sex_filter")
    private String sexFilter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "min_year")
    private String minYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "max_year")
    private String maxYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "graph_type")
    private String graphType;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public AccountData() {
    }

    public AccountData(Integer id) {
        this.id = id;
    }

    public AccountData(Integer id, String title, String dataset, String raceFilter, String sexFilter, String minYear, String maxYear, String graphType) {
        this.id = id;
        this.title = title;
        this.dataset = dataset;
        this.raceFilter = raceFilter;
        this.sexFilter = sexFilter;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.graphType = graphType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getRaceFilter() {
        return raceFilter;
    }

    public void setRaceFilter(String raceFilter) {
        this.raceFilter = raceFilter;
    }

    public String getSexFilter() {
        return sexFilter;
    }

    public void setSexFilter(String sexFilter) {
        this.sexFilter = sexFilter;
    }

    public String getMinYear() {
        return minYear;
    }

    public void setMinYear(String minYear) {
        this.minYear = minYear;
    }

    public String getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(String maxYear) {
        this.maxYear = maxYear;
    }

    public String getGraphType() {
        return graphType;
    }

    public void setGraphType(String graphType) {
        this.graphType = graphType;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountData)) {
            return false;
        }
        AccountData other = (AccountData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.EntityBeans.AccountData[ id=" + id + " ]";
    }
    
}
