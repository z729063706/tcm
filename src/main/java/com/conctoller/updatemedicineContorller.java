package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Medicine;
import com.dao.medicineDao;
import com.util.JsonUtil;
import com.util.PinYinUtil;

@WebServlet("/api/updatemedecine")
public class updatemedicineContorller extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JsonUtil.getRequestJsonObject(req);
        Integer id = json.getInteger("id");
        String name = json.getString("name");
        String metric = json.getString("metric") != null ? json.getString("metric"):"g";
        BigDecimal price = json.getBigDecimal("price");
        Integer leftnumber = json.getInteger("leftnumber") != null ? json.getInteger("leftnumber"):25535;
        String short_desc = json.getString("short_desc") != null ? json.getString("short_desc"): PinYinUtil.getFirstSpell(name);
        Medicine medicine = new Medicine(id, name, metric, price, leftnumber, short_desc);
        Boolean res = null;
        if(id == null){
            res = medicineDao.addMedicine(medicine);
        }
        else{
            res = medicineDao.updateMedecine(medicine);
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(res);
    }
}
