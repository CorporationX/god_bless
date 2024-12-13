package school.faang.moduleone.sprintone.task_43501;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_RESTRICTION = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }

    private String validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
        return address;
    }

    private String validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
        return job;
    }

    private int validateAge(int age) {
        if (age < AGE_RESTRICTION) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        return age;
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        return name;
    }
}