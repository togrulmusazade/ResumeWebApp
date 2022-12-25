/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author HP
 */
@WebServlet(name = "ErrorController", urlPatterns = {"/error"})      //servletimizin adi ve url'si qeyd etmisik
public class ErrorController extends HttpServlet {
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request,response);  //error.jsp'den cavab alnir ve oz cavabiymis kimi verir (kimə?= "error"a request kim gonderibse ona)
                                                                                // forward ile bu edilir. redirect etseydik bir basa error.jsp'e baglanacaqdi. Lakin forward baglanmir ondan cavabi ogurluyur ozununmus kimi davranir
    }






}
