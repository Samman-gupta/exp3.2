package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {
    public int save(Student s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int id = (int) session.save(s);
        tx.commit();
        session.close();
        return id;
    }

    public Student get(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class, id);
        session.close();
        return s;
    }

    public List<Student> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }

    public void update(Student s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(s);
        tx.commit();
        session.close();
    }

    public void delete(Student s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        session.close();
    }
}
