package com.bootcoding.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAO {
    private static final String TABLE_NAME = "customer";

    public void createTable() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "postgres");
            Statement stmt = con.createStatement();


           /* String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                    + " ( id int8 NOT NULL, "
                    + " name text , "
                    + " address text , "
                    + " phone_number text, "
                    + " city text, "
                    + " state text, "
                    + " email_id text, "
                    + " CONSTRAINT customer_pkey PRIMARY KEY (id)) ";

            System.out.println(" Query : " + query);*/

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
            queryBuilder.append(TABLE_NAME);
            queryBuilder.append(" ( id int8 NOT NULL, ");
            queryBuilder.append(" name text , ");
            queryBuilder.append(" address text , ");
            queryBuilder.append( " phone_number text, ");
            queryBuilder.append(" city text, ");
            queryBuilder.append(" state text, ");
            queryBuilder.append(" email_id text, ");
            queryBuilder.append(" CONSTRAINT customer_pkey PRIMARY KEY (id)) ");
            System.out.println(queryBuilder.toString());
            stmt.executeUpdate(queryBuilder.toString()); // Insert, update ,delete or create table or alter table
            // SELECT - read (executeQuery)

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
