/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecom.entities;

/**
 *
 * @author pc
 */
public class Category {
    int cId;
    
    String cName;
    
    String cDesc;

    public Category(int cId, String cName, String cDesc) {
        this.cId = cId;
        this.cName = cName;
        this.cDesc = cDesc;
    }

    public Category() {
    }
    
    

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }
    
    
    
}
