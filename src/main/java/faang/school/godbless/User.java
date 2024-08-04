package faang.school.godbless;

import lombok.*;
import java.util.*;

@Data
public class User {
    private String id;
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String id, String name, int age, String job, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect user");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}