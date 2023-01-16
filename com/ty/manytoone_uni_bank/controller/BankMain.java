package com.ty.manytoone_uni_bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.manytoone_uni_bank.dao.BankDao;
import com.ty.manytoone_uni_bank.dao.BranchDao;
import com.ty.manytoone_uni_bank.dto.Bank;
import com.ty.manytoone_uni_bank.dto.Branch;

public class BankMain {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setName("BOI");
		bank.setHeadoffice("MUMBAI");
		bank.setCeo("a.Rajshekhar");

		Branch b1 = new Branch();
		b1.setIfsc("BKID124354");
		b1.setName("wakad");
		b1.setAddress("pune");
		b1.setManager("manu");
		b1.setPhone(123324567l);

		Branch b2 = new Branch();
		b2.setIfsc("BKID5678");
		b2.setName("hadapsar");
		b2.setAddress("pune");
		b2.setManager("Snehal");
		b2.setPhone(984242l);

		Branch b3 = new Branch();
		b3.setIfsc("BKID098765");
		b3.setName("Deccan");
		b3.setAddress("pune");
		b3.setManager("satish");
		b3.setPhone(34443566676l);
		b1.setBank(bank);
		b2.setBank(bank);
		b3.setBank(bank);

		List<Branch> list = new ArrayList<Branch>();
		list.add(b3);
		list.add(b1);
		list.add(b2);
        
		boolean condition = false;

		BankDao bankDAO = new BankDao();
		BranchDao branchDao = new BranchDao();
		do {
			System.out.println("1.Insert \n 2.Update \n 3.delete \n 4.retrive by id \n 5. get all");
			Scanner scanner = new Scanner(System.in);

			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				bankDAO.saveBank(bank);
				branchDao.saveBranch(list);

				break;
			}
			case 2: {
				//bankDAO.updateBank(1, bank);
				branchDao.updateBranch(1, b3);
				break;
			}
			case 3: {
				// bankDAO.deleteBank(1);
				branchDao.deleteBranch(3);
				break;
			}
			case 4: {
				bankDAO.getBankById(1);
				
			  branchDao.getBranchById(1);
				break;
			}
			case 5: {
				bankDAO.getAllBank();
				
			  branchDao.getAllBranch();
				break;
			}
			

			default:
				break;
			}

		} while (condition);

	}

}

