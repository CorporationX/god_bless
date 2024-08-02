package faang.school.godbless.UserRegistration;

import lombok.Getter;
import java.util.Set;

@Getter
public class User {

    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String address;
    private String job;

    public User(String name, int age, String address, String job) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
        if (age < 18 || !VALID_ADDRESSES.contains(address) || !VALID_JOBS.contains(job))
        {
            throw new IllegalArgumentException("Wrong arguments, mate");
        }
    }
}
