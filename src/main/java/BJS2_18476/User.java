package BJS2_18476;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private final static int MINIMUM_AGE = 18;
    final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (validateUser(name, age, job, address)) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.job = job;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateUser(String name, int age, String job, String address) {
        if (name.isBlank()) {
            System.out.println("User name should not be empty!");
            return false;
        } else if (age < MINIMUM_AGE) {
            System.out.println(name + "'s age should be more than 18!");
            return false;
        } else if (address == null || !VALID_ADDRESSES.contains(address)) {
            System.out.println(name + "'s address " + address + " not valid!");
            return false;
        } else if (job == null || !VALID_JOBS.contains(job)) {
            System.out.println(name + "'s job " + job + " not valid!");
            return false;
        }
        return true;
    }
}