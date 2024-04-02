package faang.school.godbless.task_2;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age must be more than 18");
        }
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Not valid company");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age must be more than 18");
        }
        this.age = age;
    }

    public void setCompany(String company) {
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Not valid company");
        }
        this.company = company;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address is not valid");
        }
        this.address = address;
    }
}
