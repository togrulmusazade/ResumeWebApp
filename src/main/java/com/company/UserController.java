/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {
    
    private UserDaoInter userDao = Context.instanceUserDao();

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String name= request.getParameter("name");
        String surname= request.getParameter("surname");
        
        System.out.println("name="+name);
        System.out.println("surname="+surname);
        
        User user=userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        userDao.updateUser(user);
        
        //response.getOutputStream().println("Successfully updated!!!!");
        //response.getOutputStream().close();
        
        response.sendRedirect("user.jsp");  //redirect= yonlendirmek
    }

}
