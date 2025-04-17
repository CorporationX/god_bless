package school.faang.bjs2_69409;

import java.util.Arrays;
import java.util.List;

public class User {
    private static final int VALID_AGE = 18;
    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public User(String name, Integer age, String workplace, String address) {
        invalidate(name, age, workplace, address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    private void invalidate(String name, Integer age, String workplace, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым!");
        }

        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Указанный возраст менее 18 лет!");
        }

        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Место работы не определено");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не сущесвует!");
        }
    }
}