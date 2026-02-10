package com.klu.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // inserting records
        session.save(new Product("Laptop","Electronics",55000,10));
        session.save(new Product("Phone","Electronics",25000,5));
        session.save(new Product("Tablet","Electronics",15000,8));
        session.save(new Product("Shoes","Footwear",2000,20));
        session.save(new Product("Watch","Accessories",3000,15));
        session.save(new Product("Bag","Accessories",1200,0));

        session.getTransaction().commit();

        // Sorting Ascending
        System.out.println("PRICE ASC");
        List<Product> asc =
                session.createQuery("from Product order by price asc",Product.class).list();
        asc.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        // Pagination
        System.out.println("FIRST 3 PRODUCTS");
        Query<Product> q = session.createQuery("from Product",Product.class);
        q.setFirstResult(0);
        q.setMaxResults(3);
        q.list().forEach(p -> System.out.println(p.getName()));

        // Aggregate
        Long total = (Long) session.createQuery("select count(*) from Product").uniqueResult();
        System.out.println("TOTAL PRODUCTS = "+total);

        session.close();
    }
}

