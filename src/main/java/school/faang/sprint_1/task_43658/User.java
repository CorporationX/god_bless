package school.faang.sprint_1.task_43658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static final List<String> VALID_JOBS = new ArrayList<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final List<String> VALID_ADDRESSES = new ArrayList<>(Arrays.asList(
            "London", "New York", "Amsterdam"));
    private static final Integer VALID_AGE = 18;

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
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (!(age >= VALID_AGE)) {
            throw new IllegalArgumentException(String.format("Возраст не может быть меньше %d", VALID_AGE));
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("Недопустимое место работы. Доступно : %s", VALID_JOBS));
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format("Недопустимый адрес. Доступно : %s", VALID_ADDRESSES));
        }
        this.address = address;
    }
}
