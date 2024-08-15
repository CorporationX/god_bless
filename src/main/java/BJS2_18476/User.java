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
            throw new IllegalArgumentException("Arguments are invalid!");
        }
    }

    private boolean validateUser(String name, int age, String job, String address) {
        if (validateName(name) && validateAge(age) && validateJob(job) && validateAddress(address)) {
            return true;
        } else {
            System.out.println("Some of the parameters invalid or null!");
            return false;
        }
    }

    private boolean validateName(String name) {
        return name != null && !name.isBlank();
    }

    private boolean validateAge(int age) {
        return age > MINIMUM_AGE;
    }

    private boolean validateAddress(String address) {
        return address != null && VALID_ADDRESSES.contains(address);
    }

    private boolean validateJob(String job) {
        return job != null && VALID_JOBS.contains(job);
    }
}