package com.mavan.HibernateApp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;




public class MainEmp {

	public static void main(String[] args) 
	{
		//Step 1
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(EmployeeDemo.class);
		
		//step 2
		SessionFactory sessionFactory = config.buildSessionFactory();

		// Step 3
		Session session = sessionFactory.openSession();
		
		//Step 4
		Transaction transaction = session.beginTransaction();
		
//		EmployeeDemo emp1 = new EmployeeDemo();
//		emp1.setName("Shashikant");
//		emp1.setSalary(1200f);
//		session.save(emp1);
//		
//		
//		EmployeeDemo emp2 = new EmployeeDemo();
//		emp2.setName("Lavanya");
//		emp2.setSalary(1300f);
//		session.save(emp2);
//		
//		EmployeeDemo emp3 = new EmployeeDemo();
//		emp3.setName("Mansi");
//		emp3.setSalary(1400f);
//		session.save(emp3);
//		
//		EmployeeDemo emp4 = new EmployeeDemo();
//		emp4.setName("Ansar");
//		emp4.setSalary(1500f);
//		session.save(emp4);
//		
//		EmployeeDemo emp5 = new EmployeeDemo();
//		emp5.setName("Keerti");
//		emp5.setSalary(1600f);
//		session.save(emp5);
//		
//		transaction.commit();
//		session.close();
		
		//Max()
		Query que=session.createQuery("select max(salary) from EmployeeDemo");
		List<EmployeeDemo> list = que.list();
		System.out.println("Max salary: "+ list.get(0));
		
		//Min()
		Query que1=session.createQuery("select min(salary) from EmployeeDemo");
		List<EmployeeDemo> list1 = que1.list();
		System.out.println("Min salary: "+ list1.get(0));
		
		//Avg
		Query que2=session.createQuery("select avg(salary) from EmployeeDemo");
		List<EmployeeDemo> list2 = que2.list();
		System.out.println("Avg salary: "+ list2.get(0));
		
		//sum()
		Query que3=session.createQuery("select sum(salary) from EmployeeDemo");
		List<EmployeeDemo> list3 = que3.list();
		System.out.println("Sum salary: "+ list3.get(0));
		
		//count()
		Query que4=session.createQuery("select count(id) from EmployeeDemo");
		List<EmployeeDemo> list4 = que4.list();
		System.out.println("Count Index: "+ list4.get(0));
	}

}
