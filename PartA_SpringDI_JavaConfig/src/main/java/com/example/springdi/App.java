package com.example.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = 
            new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService svc = ctx.getBean(GreetingService.class);
        System.out.println(svc.greet("Samman"));

        ctx.close();
    }
}
