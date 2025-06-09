package school.faang.bjs2_79376;

import java.util.Set;

public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setJob(String job) {
        if (job == null || job.isBlank() && !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Такой работы нет");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank() && !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Такого адреса нет");
        }
        this.address = address;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Неподходящий возраст");
        }
        this.age = age;
    }
}
