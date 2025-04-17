package school.faang.registration;

import java.util.Set;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int LEGAL_AGE = 18;

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name can't be empty");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("You are not of legal age");
        }
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("There is no such company");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("There is no such address");
        }
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }
}
