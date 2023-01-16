package com.ty.manytoone_uni_bank.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.manytoone_uni_bank.dto.Branch;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveBranch(List<Branch> branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for (Branch b : branch) {
			entityTransaction.begin();
			entityManager.persist(b);
			entityTransaction.commit();
		}

	}

	public void updateBranch(int id,Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch fBranch = entityManager.find(Branch.class, id);
		if (fBranch != null) {
			branch.setId(id);
			// branch.setBank(receivedbranch.getBank());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		} else {
			System.out.println("Branch doesn't exsists");
		}
	}

	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, id);

		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
	}
	public Branch getBranchById(int id) {
		EntityManager entityManager = getEntityManager();
		Branch branch = entityManager.find(Branch.class, id);
		System.out.println(branch);
		return branch;
	}

	public void getAllBranch() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT b FROM Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}
}

