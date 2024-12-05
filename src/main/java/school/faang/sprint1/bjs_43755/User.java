package school.faang.sprint1.bjs_43755;

import java.util.List;

public class User {
    private static final int VALID_AGE = 18;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        checkName(name);
        checkAge(age);
        checkJob(job);
        checkAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
    }

    private void checkAge(int age) {
        if (age <= VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
    }

    private void checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        }
    }

    private void checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
    }
}