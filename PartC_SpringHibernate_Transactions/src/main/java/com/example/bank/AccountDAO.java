package com.example.bank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDAO {
    private final SessionFactory sessionFactory;
    public AccountDAO(SessionFactory sf) { this.sessionFactory = sf; }

    public Account find(int id) {
        Session s = sessionFactory.openSession();
        Account a = s.get(Account.class, id);
        s.close();
        return a;
    }

    public void update(Account a) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        s.update(a);
        tx.commit();
        s.close();
    }
}
