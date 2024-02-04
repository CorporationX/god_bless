package faang.school.godbless.r_edzie.RegisterUsers;

import java.util.Set;

public class User {
    public static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    User(String name, int age, String job, String address) {
        if (age < 18) {
            throw new IllegalArgumentException();
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (!(VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException();
        }

        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
