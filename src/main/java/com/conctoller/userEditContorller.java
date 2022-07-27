package com.conctoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dao.logDao;
import com.dao.userDao;
import com.util.JsonUtil;


@WebServlet("/api/useredit")
public class userEditContorller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JSONObject json = JsonUtil.getRequestJsonObject(req);
        PrintWriter out = resp.getWriter();
        String uname = json.getString("uname");
        String upass = json.getString("upass");
        Integer uid = Integer.parseInt(json.getString("id"));
        Integer utype = userDao.getDetail(userDao.checkUser(uname, upass)).getUtype();
        Integer histype = userDao.getDetail(uid).getUtype();
        if (utype<histype){
            resp.setStatus(403);
            out.print("{error:用户权限不足!!}");
            out.flush();
            return;
        }
        try {
            String newpass = json.getString("newpass");
            logDao.log(uname, "update "+uid+" pass to "+newpass);
            userDao.updatePass(uid, newpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print("{msg:修改成功!!}");
        out.flush();
        return;
    }
}
