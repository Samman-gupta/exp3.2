package com.example.bank;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

public class BankService {
    private final AccountDAO dao;
    public BankService(SessionFactory sf) { this.dao = new AccountDAO(sf); }

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = dao.find(fromId);
        Account to = dao.find(toId);

        if (from == null || to == null) throw new RuntimeException("Account not found");
        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        dao.update(from);
        // simulate error after debit to test transaction rollback (comment out to not throw)
        // if (true) throw new RuntimeException("Simulated failure after debit");
        dao.update(to);
    }
}
