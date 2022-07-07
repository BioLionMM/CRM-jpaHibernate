package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createCustomer()
    {
        Customer customer=new Customer();
        customer.setFirstName("Toto");
        customer.setLastName("Ro");

        CustomerDAO.create(customer);
        assertTrue( true );
    }

    @Test
    public void FindCustomerById(long id)
    {
        Customer customer=new Customer();
        customer.setFirstName("Toto");
        customer.setLastName("Ro");
        Customer customer2=CustomerDAO.findById(1L);
        assertEquals( customer2.getFirstName(),"Toto" );
    }

    @Test
    public void findAll() {

        CustomerDAO.create(new Customer("Marie"));
        CustomerDAO.create(new Customer("Michel"));
        CustomerDAO.create(new Customer("Alex"));

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());

        CustomerDAO.delete(marie);

        customers = CustomerDAO.findAll();
        assertEquals(0, customers.size());
    }

}
