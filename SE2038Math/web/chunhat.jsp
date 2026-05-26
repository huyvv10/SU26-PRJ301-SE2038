<%-- 
    Document   : chunhat
    Created on : May 26, 2026, 11:50:14 AM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tính chu vi diện tích</title>
    </head>
    <body>
        <center><h1>Tính chu vi diện tích hình Chữ nhật</h1></center>
        <form action="chunhat.jsp" method="post">
            <table>
                <tr>
                    <td>Chiều dài (cm)</td>
                    <td><input type="text" name="dai"></td>
                </tr>
                <tr>
                    <td>Chiều rộng (cm)</td>
                    <td><input type="text" name="rong"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="radio" name="method" value="cv" checked>Chu vi<br>
                        <input type="radio" name="method" value="dt">Diện tích
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Tính">
                        <input type="reset" value="Xoá">
                    </td>
                </tr>
            </table>
        </form>   
        <%!
            double chuvi(double d, double r){ return (d+r)*2;}
            double dientich(double d, double r){ return (d*r);}
        %>
        <%
        String dai = request.getParameter("dai");
        String rong = request.getParameter("rong");
        String method = request.getParameter("method");
        String err="";
        double d=0,r=0,rs=0.0;
        if (dai!=null && rong!=null && dai!="" && rong!=""){
            try {
                d = Double.parseDouble(dai);
                r = Double.parseDouble(rong);
                if (method.equals("cv")){                
        %>
        <br><div>Chu vi của hình chữ nhật là: <%=chuvi(d,r)%></div>    
        <%} else {%>
        <br><div>Diện tích của hình chữ nhật là: <%=dientich(d,r)%></div>    
        <%}
                } catch (NumberFormatException e) {
                err+="Phải nhập số";
            }
        }
        if (err!=null && err!="") {%>
            <br><div><%=err%></div>  
        <%}%>    
    </body>
</html>
