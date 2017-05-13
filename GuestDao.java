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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GuestDao {

    // Injected database connection
    //:
    @PersistenceContext(unitName = "student-unit")
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Students student) {
        em.persist(student);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    // Retrieves all the guests:
    public List<Students> getAllStudents() {
        TypedQuery<Students> query = em.createQuery(
                "SELECT s FROM Students s ORDER BY s.id", Students.class);
        return query.getResultList();
    }
}
