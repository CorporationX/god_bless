package school.faang.task_56431;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int MIN_AGE = 18;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        } else {
            this.name = name;
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес не удовлетворяет набору");
        }
        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Место работы не удовлетворяет набору");
        }

    }

}

