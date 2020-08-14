package com.home.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class fetchDataClientTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
			//getAllEmployeeUsingHQL(sf);	
			//getEmployeeById(sf);
			//getEmployeeByIdAndEmail(sf);
			//getAllEmployeesName(sf);
			getAllEmployeesIdAndName(sf);
	}

	private static void getAllEmployeesIdAndName(SessionFactory sf) {
		
         try(Session session=sf.openSession()){
			String HQL="select employeeId,employeeName From Employee";
			Query  query = session.createQuery(HQL);
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				Integer employeeId=(Integer)objects[0];
				String employeeName=(String)objects[1];
				System.out.println(employeeId+"\t"+employeeName);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getAllEmployeesName(SessionFactory sf) {
		
         try(Session session=sf.openSession()){
			String HQL="select employeeName From Employee";
			Query<String> query = session.createQuery(HQL);
			query.list().forEach(System.out:: println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getEmployeeByIdAndEmail(SessionFactory sf) {
		int empId=2;
		String email="prabhat.singh@gmail.com";
         try(Session session=sf.openSession()){
			String HQL="From Employee where employeeId=:empId AND email=:email";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			query.setParameter("empId", empId);
			query.setParameter("email", email);
			Employee employee=query.getSingleResult();
			System.out.println(employee);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getEmployeeById(SessionFactory sf) {
		int empId=2;
		try(Session session=sf.openSession()){
			
			String HQL="From Employee where employeeId=?1";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			query.setParameter(1, empId);
			Employee employee=query.getSingleResult();
			System.out.println(employee);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}

	private static void getAllEmployeeUsingHQL(SessionFactory sf) {
		try(Session session=sf.openSession()){
		String HQL="From Employee";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			List<Employee> list = query.list();
			list.forEach(System.out:: println);
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
