package com.home.client;

import java.util.Date;

import org.hibernate.Session;

import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			
			Employee employee1=new Employee();
			//BackupEmployee employee1=new BackupEmployee();
			employee1.setEmployeeName("Paras");
			employee1.setEmail("paras@gmail.com");
			employee1.setDoj(new Date());
			employee1.setSalary(16000.00);
			
			Employee employee2=new Employee();
			//BackupEmployee employee2=new BackupEmployee();
			employee2.setEmployeeName("Prabhat Singh");
			employee2.setEmail("prabhat.singh@gmail.com");
			employee2.setDoj(new Date());
			employee2.setSalary(17000.00);
			
			Employee employee3=new Employee();
			//BackupEmployee employee3=new BackupEmployee();
			employee3.setEmployeeName("Shubham");
			employee3.setEmail("shubham@gmail.com");
			employee3.setDoj(new Date());
			employee3.setSalary(18000.00);
			
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
