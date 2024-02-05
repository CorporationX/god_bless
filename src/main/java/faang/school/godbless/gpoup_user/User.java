package faang.school.godbless.gpoup_user;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
        if (age < 18) {
            throw new IllegalArgumentException();
        } else {
            this.age = age;
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException();
        } else {
            this.job = job;
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.address = address;
        }
    }
}