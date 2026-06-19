package dal;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductDao extends DBContext{
    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM tbProduct";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date impDate = rs.getDate(5);
                String catId = rs.getString(6);
                Product x = new Product(id, name, qty, price, impDate, catId);
                productList.add(x);
            }
            return productList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> searchProductsByName(String kw, String catIdKw){
        List<Product> productList = new ArrayList<>();
//        String sql1 = "SELECT * FROM tbProduct\n" +
//                     "WHERE name LIKE '%"+kw+"%'";
//        String sql2 = "SELECT * FROM tbProduct\n" +
//                     "WHERE name LIKE '%"+kw+"%' AND CatId='"+catIdKw+"'";
        String sql1 = "SELECT * FROM tbProduct\n" +
                     "WHERE name LIKE ?";
        String sql2 = "SELECT * FROM tbProduct\n" +
                     "WHERE name LIKE ? AND CatId=?";
        String sql = catIdKw.equals("all") ? sql1 : sql2;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if(kw.isEmpty() || kw==null)
                kw="''";
            ps.setString(1, "%"+kw+"%");
            ps.setString(2, catIdKw);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date impDate = rs.getDate(5);
                String catId = rs.getString(6);
                Product x = new Product(id, name, qty, price, impDate, catId);
                productList.add(x);
            }
            return productList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }    
}
