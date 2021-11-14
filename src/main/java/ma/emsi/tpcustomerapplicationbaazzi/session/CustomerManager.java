/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ma.emsi.tpcustomerapplicationbaazzi.session;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ma.emsi.tpcustomerapplicationbaazzi.entities.Customer;

/**
 *
 * @author lenovo
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

   public List<Customer> getAllCustomers() {  
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
       
    }  
        
    /**
     *
     * @param customer
     * @return
     */
    public Customer update(Customer customer) {
      return em.merge(customer); 
    }  

    public void persist(Customer customer) {
        em.persist(customer);
        }
    }

