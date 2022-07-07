package org.example.dao;

import org.example.entity.Address;
import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AddressDAO {
    public static void create(Address addressToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(addressToCreate);
        tx.commit();
    }
}
