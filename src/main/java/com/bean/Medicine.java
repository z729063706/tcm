package com.bean;


/*
 * CREATE TABLE `medicine` (
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `metric` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `leftnumber` int DEFAULT NULL,
  `short_desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 */


public class Medicine {
    private String name;
    private String metric;
    private double price;
    private int leftnumber;
    private String short_desc;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMetric() {
        return metric;
    }
    public void setMetric(String metric) {
        this.metric = metric;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getLeftnumber() {
        return leftnumber;
    }
    public void setLeftnumber(int leftnumber) {
        this.leftnumber = leftnumber;
    }
    public String getShort_desc() {
        return short_desc;
    }
    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }
    
}
