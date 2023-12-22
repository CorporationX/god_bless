package faang.school.godbless.java_core.regis_user;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }


}
