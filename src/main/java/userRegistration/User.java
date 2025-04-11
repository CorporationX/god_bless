package userRegistration;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final List<String> VALID_JOBS = new ArrayList<>(List.of("Google", "Uber", "Amazon"));
    public static final List<String> VALID_ADDRESSES = new ArrayList<>(List.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
        this.address = address;
    }

}
