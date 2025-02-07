package school.faang.spring1.basicjava.userregistration;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Amazon", "Uber");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "Amsterdam", "New York");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
    }
}
