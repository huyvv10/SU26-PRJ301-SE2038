<%-- 
    Document   : myjsp
    Created on : May 26, 2026, 10:51:14 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My JSP Page</title>
    </head>
    <body>
    <center><h1>Hello JSP World!</h1></center>
    <%!
        char toChar(int i){
            return (char)(65+i);
        }
    %>
    <% int n=26; 
        for (int i=0; i<n; i++){
    %>
    <p><h3><%=i+1%>. Anh yêu em!</h3></p>
    <%}%>
    <hr>
    <table border="1px">
        <tr>
            <th>STT</th>
            <th>Họ và tên</th>
            <th>Ghi chú</th>
        </tr>
        <%
            for (int i=0; i<n; i++){
        %>
        <tr>
            <td><%=i+1%></td>
            <td>Nguyễn Văn <%=toChar(i)%></td>
            <td></td>
        </tr>
        <%}%>
    </table>
    </body>
</html>
