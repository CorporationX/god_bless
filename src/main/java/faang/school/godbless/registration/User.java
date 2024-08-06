package faang.school.godbless.registration;

import lombok.Getter;

import java.util.*;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) throws IllegalArgumentException {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(company) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.company = company;
            this.address = address;
        }
    }
}
