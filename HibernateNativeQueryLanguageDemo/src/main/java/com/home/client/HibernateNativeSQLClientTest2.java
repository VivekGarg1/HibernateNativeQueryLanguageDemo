package com.home.client;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.home.entities.Employee;
import com.home.entities.Phone;
import com.home.util.HibernateUtil;

public class HibernateNativeSQLClientTest2 {

	public static void main(String[] args) {
		getPhoneEntity();

	}

	private static void getPhoneEntity() {
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			List<Phone> phones = session.createNativeQuery("select phone_id,phone_number,phone_type,employee_id from phone").addEntity(Phone.class).list();
			for (Phone phone : phones) {
				System.out.println("Phone details...");
				System.out.println("Phone id: "+phone.getPhoneId());
				System.out.println("Phone number: "+phone.getPhoneNumber());
				System.out.println("Phone type: "+phone.getPhoneType());
				Employee employee = phone.getEmployee();
				if(employee!=null) {
					System.out.println(employee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
