package com.bootcoding.restaurant.dao;

import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.model.OrderMenuItem;
import com.bootcoding.restaurant.model.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    public static final String TABLE_NAME = "customer_order";
    public void createTable(){
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "postgres");
            Statement stmt = con.createStatement();


            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" total_amount decimal , ");
            queryBuilder.append(" vendor_id int8 , ");
            queryBuilder.append( " customer_id int8, ");
            queryBuilder.append(" delivery_address text, ");
            queryBuilder.append(" order_date timestamp, ");
            queryBuilder.append(" order_status text, ");
            queryBuilder.append(" CONSTRAINT order_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString()); // Insert, update ,delete or create table or alter table
            // SELECT - read (executeQuery)

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
