/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecom.dao;

import com.ecom.entities.Category;
import com.ecom.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CategoryDao {

    Connection con;

    public CategoryDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery("select * from category");
            list = new ArrayList<>();

            while (set.next()) {
                Category cat = new Category();
                cat.setcId(set.getInt("cId"));
                cat.setcName(set.getString("cName"));
                cat.setcDesc(set.getString("cDesc"));

                list.add(cat);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return list;
    }
}
