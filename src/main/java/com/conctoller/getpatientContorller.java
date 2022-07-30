package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Patient;
import com.dao.patientDao;

@WebServlet("/api/getpatient")
public class getpatientContorller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer lim = req.getParameter("limit") == null ? 10000 : Integer.parseInt(req.getParameter("limit"));
        List<Patient> patient = patientDao.patientList(lim);
        JSONArray patientJsonArray = new JSONArray();
        patientJsonArray = JSONArray.parseArray(JSONObject.toJSONString(patient));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(patientJsonArray);
    }
}
