package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class StudentConfiguration {

	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		Session session=null;
		Transaction t=null;
		Student s=null;
		
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
	try {
		session=sf.openSession();
		t=session.beginTransaction();  
		//Student s=new Student();
		

		/*s.setId(104);
		s.setFname("Seema");
		s.setLname("Tripathi");
		s.setContact("2345");
		s.setAddress("London"); */
	
	    s=(Student)session.get(Student.class,104);
	    t.commit();
	    System.out.print("Fetched Student Object From Db::"+s);
	} catch(HibernateException ex) {
	    if(t != null)
	       t.rollback();
	    System.out.print("problem in saving into database successfully");
	       ex.printStackTrace();
	}
	catch (Exception e) {
		t.rollback();
		 System.out.print("problem in saving into database successfully");
		e.printStackTrace();
	}
	finally {
	    session.close();
	    sf.close();
	}
	}}
	


