
import dal.StudentDAO;
import java.util.ArrayList;
import java.util.List;
import models.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VU VAN HUY
 */
public class TestMain {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<Student> myStd = new ArrayList<>();
        //Delete student by ID
        dao.deleteStudent("He200014");
        
        myStd = dao.getAllStudent();
        
        for (Student s : myStd) {
            System.out.println(s.toString());
        }
    }
}
