package com.example.hibernate;

import java.util.List;

public class StudentApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // create
        int id = dao.save(new Student("Alice", "alice@example.com"));
        System.out.println("Inserted student id=" + id);

        // read
        Student s = dao.get(id);
        System.out.println("Fetched: " + s);

        // update
        s.setEmail("alice.new@example.com");
        dao.update(s);
        System.out.println("Updated.");

        // list
        List<Student> all = dao.listAll();
        System.out.println("All students: " + all);

        // delete
        dao.delete(s);
        System.out.println("Deleted.");

        HibernateUtil.shutdown();
    }
}
