package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.util.Gender;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
    public void FindCustomerById()
    {
        Customer customer=new Customer();
        customer.setFirstName("Toto");
        customer.setLastName("Ro");
        Customer customer2=CustomerDAO.findById(9L);
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

    @Test
    public void deleteCustomerById(){
        Customer customerA=new Customer("Sacha");
        Customer customerB=new Customer("Ondine");
        Customer customerC=new Customer("Pierre");
        Customer customerD=new Customer("Regis");

        CustomerDAO.create(customerA);
        CustomerDAO.create(customerB);
        CustomerDAO.create(customerC);
        CustomerDAO.create(customerD);

        CustomerDAO.deleteCustomerById(8l);


        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(4, customers.size());

        CustomerDAO.deleteCustomerById(4);

        customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setAddress("rue de la mairie");
        customer.setCity("Paris");
        customer.setCompanyName("Google");
        customer.setCountry("France");
        customer.setEmail("alain@delon.fr");
        customer.setPhone("060606060606");
        customer.setZipCode("75000");
        customer.setState(1);
        CustomerDAO.create(customer);

        /*****************/

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("Jean-Paul");
        newCustomerData.setLastName("Belmondo");

        CustomerDAO.update(customer.getId(), newCustomerData);

        /*****************/

        Customer updatedCustomer = CustomerDAO.findById(customer.getId());
        assertEquals("Jean-Paul", updatedCustomer.getFirstName());
        assertEquals("Belmondo", updatedCustomer.getLastName());

    }

    @Test
    public void createCustomerWithGender()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setGender(Gender.OTHER);

        CustomerDAO.create(customer);

        assertTrue( true );
    }
    @Test
    public void dontFindById() {
        Customer customer = CustomerDAO.findById(5);
        assertNull(customer);
    }
    @Test
    public void selectWhere(){
        Customer customer1 = new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        CustomerDAO.create(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alain");
        customer2.setLastName("Prost");
        CustomerDAO.create(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Marie");
        customer3.setLastName("Dupont");
        CustomerDAO.create(customer3);

        /*****************/

        List<Customer> alains = CustomerDAO.findByFirstName("Alain");

        /*****************/

        assertEquals(2, alains.size());

        for(Customer c : alains){
            if(! c.getFirstName().equals("Alain")){
                assertTrue(false);
            }
        }
    }

}
