<%-- 
    Document   : addstudent
    Created on : Jun 12, 2026, 8:14:09 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new student</title>
    </head>
    <body>
    <center><h1>Add new student</h1></center>
    <form action="addstudent" method="post">
        <table border="0">
            <tr>
                <td>Student Id</td>
                <td><input type="text" name="txtId" id="txtId"></td>
            </tr>
            <tr>
                <td>Student name</td>
                <td><input type="text" name="txtName" id="txtName"></td>
            </tr>
            <tr>
                <td>Student DOB</td>
                <td><input type="text" name="txtDob" id="txtDob"></td>
            </tr>
            <tr>
                <td>Student Gender</td>
                <td>
                    <input type="radio" name="rbGender" id="rbNam" value="M">Nam
                    <input type="radio" name="rbGender" id="rbNu" value="F">Nữ
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add student" id="btnAdd"></td>
            </tr>
        </table>

    </form>
</body>
</html>
