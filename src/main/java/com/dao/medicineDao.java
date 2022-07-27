package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.Medicine;
import com.util.c3p0Util;
public class medicineDao {
    public static Boolean addMedicine(Medicine medicine){
        String sql = " INSERT INTO MEDICINE (NAME, METRIC, PRICE, LEFTNUMBER, SHORT_DESC) VALUES (?, ?, ?, ?, ?) ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try {
            qr.update(sql, medicine.getName(), medicine.getMetric(), medicine.getPrice(), medicine.getLeftnumber(), medicine.getShort_desc());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static List<Medicine> medicineList(Integer limInteger){
        String sql = "SELECT * FROM MEDICINE LIMIT ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        List<Medicine> res = null;
        ResultSetHandler<List<Medicine>> rsh = new BeanListHandler<Medicine>(Medicine.class);
        try {
            res = qr.query(sql, rsh, limInteger);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
