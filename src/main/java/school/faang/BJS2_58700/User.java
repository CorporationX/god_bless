package school.faang.BJS2_58700;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        } else if (!validateAge(age)) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        } else if (validateJob(job)) {
            throw new IllegalArgumentException("Место работы должно быть одно из следующих: " + VALID_JOBS);
        } else if (validateAddress(address)) {
            throw new IllegalArgumentException("Адрес должен быть одним из следующих: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean validateName(String name) {
        if (name.isBlank()) {
            return false;
        }
        return true;
    }

    private boolean validateAge(int age) {
        if (age < MIN_AGE) {
            return false;
        }
        return true;
    }

    private boolean validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            return false;
        }
        return true;
    }

    private boolean validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            return false;
        }
        return true;
    }
}