<%-- 
    Document   : user
    Created on : Nov 27, 2022, 5:33:50 PM
    Author     : HP
--%>


<%@page import="com.company.entity.User"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.main.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <%
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getByID(6);
        %>

        <div>
            <form action="UserController" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                <label for="name"> name:</label> 
                <input type="text" name="name" value="<%=u.getName()%>"/>
                <br/>
                <label for="surname"> surname:</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>"/>    

                <input type="submit" name="save" value="Save"/>
            </form>
        </div>


    </body>
</html>
