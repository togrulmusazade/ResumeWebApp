<%-- 
    Document   : user
    Created on : Nov 27, 2022, 5:33:50 PM
    Author     : HP
--%>


<%@page import="com.company.entity.User" %>
<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.main.Context" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <script src="https://kit.fontawesome.com/421eb83fc8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>JSP Page</title>
</head>

<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");

    String nationalityIdStr = request.getParameter("nid");
    Integer nationalityId = null;
    if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nationalityIdStr);
    }
    List<User> list = userDao.getAll(name, surname, nationalityId);
%>
<div class="container mycontainer">

    <div>
        <form action="users.jsp" method="GET">
            <div class="form-group">
                <label for="name"> name:</label>
                <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
            </div>
            <div class="form-group">
                <label for="surname"> surname:</label>
                <input placeholder="Enter surname" class="form-control" type="text" name="surname" value=""/>
            </div>

            <input class="btn btn-primary" type="submit" name="search" value="Search"/>
        </form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (User u : list) {
            %>
            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%></td>
                <td>
                    <button class="btn btn-danger" type="submit" name="action" value="delete">
                        <i class="fa-sharp fa-solid fa-trash"></i>
                    </button>

                    <button class="btn btn-secondary" type="submit" name="action" value="update">
                        <i class="fa-solid fa-square-pen"></i>
                    </button>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
