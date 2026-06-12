<%-- 
    Document   : updatestudent
    Created on : Jun 12, 2026, 9:03:38 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student info</title>
    </head>
    <body>
   <center><h1>Update student info</h1></center>
    <form action="update" method="post">
        <table border="0">
            <tr>
                <td>Student Id</td>
                <td><input type="text" name="txtId" id="txtId" value="${stdX.id}" readonly></td>
            </tr>
            <tr>
                <td>Student name</td>
                <td><input type="text" name="txtName" id="txtName" value="${stdX.name}"></td>
            </tr>
            <tr>
                <td>Student DOB</td>
                <td><input type="text" name="txtDob" id="txtDob" value="${stdX.dob}"></td>
            </tr>
            <tr>
                <td>Student Gender</td>
                <td>
                    <input type="radio" name="rbGender" id="rbNam" value="M" ${stdX.gender=="Nam"?"checked":""}>Nam
                    <input type="radio" name="rbGender" id="rbNu" value="F" ${stdX.gender=="Nữ"?"checked":""}>Nữ
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update student" id="btnUpdate"></td>
            </tr>
        </table>

    </form>
    </body>
</html>
