package faang.school.godbless.BJS2_4187;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        dataValidation(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void dataValidation(String name, int age, String job, String address) {
        if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        if (age < 18) throw new IllegalArgumentException("Age cannot be under 18");
        if (!VALID_JOBS.contains(job)) throw new IllegalArgumentException("Invalid job: " + job);
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Invalid address: " + address);
    }
}
