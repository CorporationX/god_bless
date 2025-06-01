package school.faang.BJS2_79141;

import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York");

    public User(String name, int age, String job, String address) {
        if (!(isValidName(name) && isValidAge(age) && isValidJob(job) && isValidAddress(address))) {
            throw new IllegalArgumentException("Invalid argument for user");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean isValidName(String name) {
        return !name.isEmpty();
    }

    private boolean isValidAge(int age) {
        return age >= 18;
    }

    private boolean isValidJob(String job) {
        return VALID_JOBS.contains(job);
    }

    private boolean isValidAddress(String address) {
        return VALID_ADDRESSES.contains(address);
    }

}
