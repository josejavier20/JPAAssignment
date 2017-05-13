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
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class GuestController {
 
    @Autowired
    private GuestDao guestDao;
 
    @RequestMapping(value="/student")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Students(name));
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("student.jsp", "guestDao", guestDao);
    }
}