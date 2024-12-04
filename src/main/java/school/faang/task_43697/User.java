package school.faang.task_43697;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    public static final int MIN_AGE = 18;

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

    private void checkAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
    }

    private void checkJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS.");
        }
    }

    private void checkAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
    }

    private void checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым.");
        }
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, job='%s', address='%s'}", name, age, job, address);
    }

    public static void main(String[] args) {
        System.out.println(new User("Oleg", 19, "Uber", "London").toString());
    }
}

