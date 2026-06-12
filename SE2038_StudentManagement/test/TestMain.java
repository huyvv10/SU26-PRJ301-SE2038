
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
//        dao.deleteStudent("He200014");
        dao.addStudent("He200003", "Gì cũng được", "2000-12-31", "Nữ");

        myStd = dao.getAllStudent();
        
        for (Student s : myStd) {
            System.out.println(s.toString());
        }
        
        System.out.println("");
        Student x = dao.getStudentById("He200002");
        System.out.println(x.toString());
        
        dao.updateStudent("He200003", "Lã Bất Vi", "1800-01-01", "Nam");

        System.out.println("");
        x = dao.getStudentById("He200003");
        System.out.println(x.toString());        
    }
}
