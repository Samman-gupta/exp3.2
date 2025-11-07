package com.example.springdi;

public class GreetingServiceImpl implements GreetingService {
    private final GreetingFormatter formatter;

    public GreetingServiceImpl(GreetingFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String greet(String name) {
        return formatter.format(name);
    }
}
