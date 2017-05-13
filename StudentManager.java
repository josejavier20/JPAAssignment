/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAAssignment;

/**
 *
 * @author Jose Javier Silva Ra
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManager {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});

        GuestDao dao = (GuestDao) context.getBean("guestDao");

        Students student = new Students();
        student.setFirstname("Test FName");
        student.setLastname("Test LName");
        student.setAge("25");

        try {

            dao.persist(student);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
