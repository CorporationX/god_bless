package users_registartion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Amazon", "Uber");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        validateFields(name, age, work, address);
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public void validateFields(String name, int age, String work, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        if (age <= 18) {
            throw new IllegalArgumentException("Not the right age.");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Invalid work.");
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address.");
        }
    }
}

