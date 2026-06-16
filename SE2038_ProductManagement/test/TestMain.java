
import dal.CategoryDao;
import java.util.ArrayList;
import java.util.List;
import models.Category;

public class TestMain {
    public static void main(String[] args) {
        CategoryDao catDao = new CategoryDao();
        List<Category> catList = new ArrayList<>();
        catList = catDao.getAllCategories();
        
        for (Category c : catList) {
            System.out.println(c.toString());
        }
    }
}
