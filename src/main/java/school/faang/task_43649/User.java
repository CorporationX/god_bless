package school.faang.task_43649;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int MIN_AGE = 18;
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
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;
            return;
        }
        throw new IllegalArgumentException("Место работы должно быть в наборе VALID_JOBS");
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
            return;
        }
        throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
    }
}