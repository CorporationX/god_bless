package school.faang.bjs2_79376;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        return name;
    }

    private int validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        return  age;
    }

    private String validateJob(String job) {
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимая работа");
        }
        return job;
    }

    private String validateAddress(String address) {
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый аддрес");
        }
        return address;
    }
}
