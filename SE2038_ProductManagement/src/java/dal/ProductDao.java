package dal;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDao extends DBContext{
    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM tbProduct";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
            }
            return productList;
        } catch (Exception e) {
        }
        return null;
    }
    
}
