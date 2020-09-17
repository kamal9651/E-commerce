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
public class User {
    private int uId;
    private String uName;
    private String uPass;
    private String uEmail;
    private String uPic;
    private String uAbout;
    private String uType;

    public User(int uId, String uName, String uPass, String uEmail, String uPic, String uAbout, String uType) {
        this.uId = uId;
        this.uName = uName;
        this.uPass = uPass;
        this.uEmail = uEmail;
        this.uPic = uPic;
        this.uAbout = uAbout;
        this.uType = uType;
    }

    public User()
    {
        
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPic() {
        return uPic;
    }

    public void setuPic(String uPic) {
        this.uPic = uPic;
    }

    public String getuAbout() {
        return uAbout;
    }

    public void setuAbout(String uAbout) {
        this.uAbout = uAbout;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }
    
    
    
    
    
    
}
