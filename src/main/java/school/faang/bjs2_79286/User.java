package school.faang.bjs2_79286;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Работа должна содержаться в наборе " + VALID_JOBS);
        } else {
            this.job = job;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе " + VALID_ADDRESSES);
        } else {
            this.address = address;
        }
    }
}
