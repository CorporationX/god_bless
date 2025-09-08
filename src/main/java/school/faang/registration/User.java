package school.faang.registration;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int ABS_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null");
        }

        if (age < ABS_AGE) {
            throw new IllegalArgumentException("Возраст не может быть < 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Некорректное место работы. Допустимые места: " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес. Допустимые адреса: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User {имя: " + name + ", возраст: " + age +
                ", место работы: " + job + ", город: " + address + "}";
    }
}