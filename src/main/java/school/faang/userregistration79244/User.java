package school.faang.userregistration79244;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final int minUserAge = 18;

    public User(String name, int age, String job, String address) {
        List<String> errors = new ArrayList<>();
        if (name == null || name.isBlank()) {
            errors.add("Вы не ввели имя");
        }
        if (age < minUserAge) {
            errors.add("Возраст должен быть от 18 ");
        }
        if (!VALID_JOBS.contains(job)) {
            errors.add("Указанно не допустимое место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            errors.add("Указан не допустимый адрес");
        }
        if (errors.isEmpty()) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
        if (!errors.isEmpty()) {
            if (errors.size() == 1) {
                throw new IllegalArgumentException("Допущена ошибка ввода у " + String.join(" ,", errors));
            } else {
                throw new IllegalArgumentException("Допущены ошибки ввода " + String.join(" ,", errors));
            }
        }
    }
}
