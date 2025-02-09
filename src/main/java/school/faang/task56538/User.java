package school.faang.task56538;

import lombok.Getter;
import lombok.NonNull;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    @NonNull
    public User(String name, int age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }

    private String validateName(String name) {
        if (name != null && !name.isEmpty()) {
            return name;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым.");
        }
    }

    private int validateAge(int age) {
        if (age >= MIN_AGE) {
            return age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18. Получено: " + age);
        }
    }

    private String validateJob(String job) {
        if (job != null && VALID_JOBS.contains(job)) {
            return job;
        } else {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS. Получено: " + job);
        }
    }

    private String validateAddress(String address) {
        if (address != null && VALID_ADDRESSES.contains(address)) {
            return address;
        } else {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES. Получено: "
                    + address);
        }
    }
}
