package school.faang.registration;

import java.util.List;

public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        this.name = name;   // Не может быть пустым
        this.age = age;     // Не может быть больше 18
        this.job = job;     // Из набора
        this.address = address; // Из набора

        validateDataInput(name, age, job, address);
    }

    private void validateDataInput(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        }
        if (age > 18) {
            throw new IllegalArgumentException("Age need to be less than or equal 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Wrong job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong address");
        }
    }
}
