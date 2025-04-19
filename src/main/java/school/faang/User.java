package school.faang;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private String address;

    static final int MIN_AGE = 18;
    static final Set<String> VALID_JOBS = new HashSet<>();
    static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, int age, String job, String address) {
        validateName(name);
        validateAge(age);
        validatejob(job);
        validateAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    private void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(String.format("Возраст не может быть меньше %d лет", MIN_AGE));
        }
    }

    private void validatejob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format(
                    "Недопустимое место работы. Допустимые варианты: %s", VALID_JOBS));
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format(
                    "Недопустимый адрес. Допустимые выарианты: %s", VALID_ADDRESSES));
        }
    }

    public String toString() {
        return "User{name='" + name + "', age=" + age + ", job='" + job + "', address='" + address + "'}";
    }
}