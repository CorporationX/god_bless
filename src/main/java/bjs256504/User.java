package bjs256504;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        UserConstructorValidator.validate(name, age, job, address, VALID_JOBS, VALID_ADDRESSES);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}




