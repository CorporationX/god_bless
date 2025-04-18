package school.faang;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public static final Set<String> VALID_JOBS = new HashSet<>();
    public static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы. Допустимые варианты: " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес. Допустимые варианты: " + VALID_ADDRESSES);
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
}