package com.example.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService svc = ctx.getBean(BankService.class);

        try {
            svc.transfer(1, 2, 500);
            System.out.println("Transfer succeeded");
        } catch (Exception ex) {
            System.err.println("Transfer failed: " + ex.getMessage());
        }

        ctx.close();
    }
}
