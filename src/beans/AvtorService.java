package beans;

import tables.Avtor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Yevhen on 15.12.2015.
 */
@Stateless
public class AvtorService {
    @PersistenceContext
    EntityManager em;

    public List<Avtor> findAll() {
        return em.createNamedQuery("Avtor.findAll").getResultList();
    }

    public Avtor find(Integer id) {
        return em.find(Avtor.class, id);
    }

    public Avtor create(String name, String comment) {
        Avtor avtor = new Avtor(name, comment);
        em.persist(avtor);
        return avtor;
    }
}
