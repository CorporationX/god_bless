package school.faang.futureworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", job='" + job + '\''
                + ", address='" + address + '\''
                + '}';
    }

    public User(String name, int age, String job, String address) {
        nameNotEmpty(name);
        checkAge(age);
        checkJob(job);
        checkAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void nameNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
    }

    private void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
    }

    private void checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
    }

    private void checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
    }
}
