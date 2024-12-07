package school.faang.task_bjs243736;

import lombok.Data;

import java.util.Set;


@Data
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("имя отсутствует");
        } else {
            this.name = name;
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст слишком мал");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Некорректная работа");
        } else {
            this.job = job;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес");
        } else {
            this.address = address;
        }
    }
}
