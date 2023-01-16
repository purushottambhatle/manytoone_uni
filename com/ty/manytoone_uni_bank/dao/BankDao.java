package com.ty.manytoone_uni_bank.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.manytoone_uni_bank.dto.Bank;

public class BankDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveBank(Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}

	public void updateBank(int id, String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank receivedbank = entityManager.find(Bank.class, id);
		if (receivedbank != null) {
			receivedbank.setName(name);
			entityTransaction.begin();
			entityManager.merge(receivedbank);
			entityTransaction.commit();
		} else {
			System.out.println("Bank doesn't exists");
		}
	}

	public void deleteBank(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank = entityManager.find(Bank.class, id);

		entityTransaction.begin();
		entityManager.remove(bank);
		entityTransaction.commit();
	}

	public Bank getBankById(int id) {
		EntityManager entityManager = getEntityManager();
		Bank bank = entityManager.find(Bank.class, id);
		System.out.println(bank);
		return bank;
	}

	public void getAllBank() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT b FROM Bank b");
		List<Bank> list = query.getResultList();
		System.out.println(list);

	}

}
