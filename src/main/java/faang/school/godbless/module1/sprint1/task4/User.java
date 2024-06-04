package faang.school.godbless.module1.sprint1.task4;


import java.util.HashSet;
import java.util.Set;


public record User(String name, int age, String jobTitle, String location) {
    private static final Set<String> VALID_JOBS = new HashSet<>();
    private static final Set<String> VALID_ADDRESSES = new HashSet<>();

    public User(String name, int age, String jobTitle, String location) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.jobTitle = validateJobTitle(jobTitle);
        this.location = validateLocation(location);
    }


    private static String validateJobTitle(String jobTitle) {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("UBER");
        VALID_JOBS.add("Amazon");
        if (VALID_JOBS.contains(jobTitle)) {
            return jobTitle.trim();
        } else {
            throw new IllegalArgumentException("Job title does not exist");
        }
    }

    private static String validateLocation(String location) {
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("Amsterdam");
        VALID_ADDRESSES.add("New York");
        if (VALID_ADDRESSES.contains(location)) {
            return location.trim();
        } else {
            throw new IllegalArgumentException("Location does not exist");
        }
    }

    private int validateAge(int age) {
        if (age > 18) {
            return age;
        } else {
            throw new IllegalArgumentException("Age does not exist");
        }
    }

    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name.trim();
    }
}
