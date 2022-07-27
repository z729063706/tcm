package com.conctoller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.dao.logDao;
import com.dao.userDao;

@Controller
public class loginContorller {
    @RequestMapping(value="/login",produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userDao.getDetail(1);
        return JSONObject.toJSONString(user);
        // response.setContentType("text/html;charset=utf-8");
        // response.setCharacterEncoding("utf-8");
        // request.setCharacterEncoding("utf-8");
        // String uname = request.getParameter("uname");
        // String upass = request.getParameter("upass");
        // PrintWriter out = response.getWriter();
        // JSONObject json = new JSONObject();
        // Integer uid = userDao.checkUser(uname, upass);
        // if (uid > 0){
        //     User user = userDao.getDetail(uid);
        //     //         resp.setCharacterEncoding("UTF-8");
        //     //         logDao.log(user.getUname(), "Login");
        //     //         out.write(JSONObject.toJSONString(user).getBytes("UTF-8"));
        //     //         out.flush();
        //     json.put("code", 1);
        //     json.put("msg", "登录成功");
        //     json.put("user", user);
        //     out.print(json);
        //     out.flush();
        //     out.close();
        //     return "Hello";
        // }
        // else {
        //     json.put("code", 0);
        //     json.put("msg", "用户名或密码为空");
        //     out.print(json);
        //     out.flush();
        //     out.close();
        //     return "Hello";
        // }
        
    }
    // protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     String uname = req.getParameter("uname");
    //     String upass = req.getParameter("upass");
    //     Integer uid = userDao.checkUser(uname, upass);
    //     OutputStream out = resp.getOutputStream();
    //     if (uid > 0){
    //         User user = userDao.getDetail(uid);
    //         resp.setCharacterEncoding("UTF-8");
    //         logDao.log(user.getUname(), "Login");
    //         out.write(JSONObject.toJSONString(user).getBytes("UTF-8"));
    //         out.flush();
    //     }
    //     else{
    //         resp.setCharacterEncoding("UTF-8");
    //         //resp.setStatus(403);
    //         out.write("用户名或密码错误".getBytes("UTF-8"));
    //         out.flush();
    //     }
        

        
    // }
    
}
