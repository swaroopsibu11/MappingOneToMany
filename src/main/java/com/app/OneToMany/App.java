package com.app.OneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Vendor v = new Vendor();
        v.setVendorId(100);
        v.setVendorName("HSBC");
        
        Customers c1 = new Customers();
        c1.setCustomerId(500);
        c1.setCustomerName("Evry");
        
        Customers c2 = new Customers();
        c1.setCustomerId(501);
        c1.setCustomerName("Delloite");
        
        Set s = new HashSet();
        s.add(c1);
        s.add(c2);
        
        v.setChildren(s);
        
        Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
        
        session.close();
        System.out.println("successfuly OneToMany implemented");
        factory.close();
        
       
    }
}
