package faang.school.godbless.user_registration;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        if (!name.isBlank())
            this.name = name;
        else throw new IllegalArgumentException("Name cannot be empty");

        if (age >= 18)
            this.age = age;
        else throw new IllegalArgumentException("Age can't be less than 18");

        if (VALID_JOBS.contains(company))
            this.company = company;
        else
            throw new IllegalArgumentException("""
                    Company name should be equals to Google, Uber, Amazon!
                    """);

        if (VALID_ADDRESSES.contains(address))
            this.address = address;
        else throw new IllegalArgumentException("""
                Address cannot be blank or null. Address isn't equal to London, New York, or Amsterdam
                """);
    }
}
