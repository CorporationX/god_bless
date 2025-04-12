package school.faang.userregistration;

import lombok.ToString;

import java.util.List;

@ToString
public class User {
    public static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    public static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    public static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;

        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MINIMUM_AGE);
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе Google, Uber, Amazon");
        }
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе London, New York, Amsterdam");
        }
        this.address = address;
    }
}
