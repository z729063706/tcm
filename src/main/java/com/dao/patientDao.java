package com.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bean.Patient;
import com.util.c3p0Util;

/*
 * CREATE TABLE `patient` (
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lastcome` timestamp NULL DEFAULT NULL,
  `symptom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
 */
public class patientDao {
    public static List<Patient> patientList(Integer limInteger){
        String sql = "SELECT * FROM PATIENT ORDER BY `NAME` LIMIT ? ";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        List<Patient> res = null;
        ResultSetHandler<List<Patient>> rsh = new BeanListHandler<Patient>(Patient.class);
        try {
            res = qr.query(sql, rsh, limInteger);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    //添加患者
    public static void addPatient(Patient patient){
        String sql = "INSERT INTO PATIENT(NAME,PHONE,ADDRESS,AGE,SEX,SYMPTOM,MONEY) VALUES(?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(c3p0Util.dataSource);
        try{
            qr.update(sql,patient.getName(),patient.getPhone(),patient.getAddress(),patient.getAge(),patient.getSex(),patient.getSymptom(),patient.getMoney());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
