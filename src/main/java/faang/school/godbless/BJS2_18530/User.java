package faang.school.godbless.BJS2_18530;

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
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(company) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }
}
