<%-- 
    Document   : calculator
    Created on : Jun 2, 2026, 11:10:48 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT Calculator</title>
    </head>
    <body>
    <center><h1>SE2038 PRJ301 Calculator</h1></center>
    <form action="calculate" method="post">
        <table border="0">
            <tr>
                <td>Number 1</td>
                <td><input type="text" name="txtNum1" id="txtn1" value="${n1}"></td>
            </tr>
            <tr>
                <td>Number 2</td>
                <td><input type="text" name="txtNum2" id="txtn2" value="${n2}"></td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <input type="radio" name="op" id="rbSum" value="+" checked>Sum<br>
                    <input type="radio" name="op" id="rbSub" value="-">Subtract<br>
                    <input type="radio" name="op" id="rbProd" value="*">Product<br>
                    <input type="radio" name="op" id="rbQuo" value="/">Quotient<br>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate" id="btnCal"></td>
            </tr>
        </table>
    </form>
    <hr>
    <p style="color:red">${errmess}</p>
    <table border="1">
        <thead>
            <tr>
                <th>Number 1</th>
                <th>Operator</th>
                <th>Number 2</th>
                <th></th>
                <th>Result</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="i" items="${lstData}">
            <tr>
                <td>${i.n1}</td>
                <td>${i.op}</td>
                <td>${i.n2}</td>
                <td>=</td>
                <td>${i.rs}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
