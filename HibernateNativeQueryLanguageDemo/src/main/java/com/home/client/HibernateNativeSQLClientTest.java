package com.home.client;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class HibernateNativeSQLClientTest {

	public static void main(String[] args) {
		//getPersonInfoV1();
		//getPersonInfoV2();
		//getPersonInfoV3();
		getPersonEntityV1();

	}

	private static void getPersonEntityV1() {
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			List<Employee> list = session.createNativeQuery("select * from employee_table").addEntity(Employee.class).list();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getPersonInfoV3() {
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> list = session.createNativeQuery("select employee_id,employee_name from employee_table")
					.addScalar("employee_id").addScalar("employee_name").list();
			for (Object[] objects : list) {
				Integer id=(Integer)objects[0];
				String name=(String) objects[1];
				System.out.println(id+"\t"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getPersonInfoV2() {
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> list = session.createNativeQuery("select employee_id,employee_name from employee_table")
					.addScalar("employee_id", IntegerType.INSTANCE).addScalar("employee_name", StringType.INSTANCE).list();
			for (Object[] objects : list) {
				Integer id=(Integer)objects[0];
				String name=(String) objects[1];
				System.out.println(id+"\t"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getPersonInfoV1() {
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			
			List<Object[]> list = session.createNativeQuery("select * from employee_table").list();
			for (Object[] objects : list) {
				Integer id=(Integer)objects[0];
				String name=(String) objects[3];
				System.out.println(id+"\t"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
