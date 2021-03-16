package model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
public class OneMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAOneMany");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Supplier sp = new Supplier();
		sp.setCity("Taipei");
		sp.setSupName("Gjun");
		sp.setState("TW");
		sp.setStreet("Kung Yuan Road");
		sp.setZip("101");
		sp.setSupId(1);
		Coffee c1=new Coffee();
		c1.setCofName("Flavor A");
		c1.setPrice(new BigDecimal(200.0));
		c1.setSales(10);
		c1.setTotal(5);
		c1.setSupplier(sp);
		Coffee c2=new Coffee();
		c2.setCofName("Flavor B");
		c2.setPrice(new BigDecimal(100.0));
		c2.setSales(11);
		c2.setTotal(6);
		c2.setSupplier(sp);
		em.persist(c1);
		em.persist(c2);
		ArrayList<Coffee> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		sp.setCoffees(list);
		em.persist(sp);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}