package school.faang.task_43728;

import java.util.Set;

public class User {
    private static final int VALID_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws Exception {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым!");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст пользователя должен быть больше 18!");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Некорректное место работы пользователя!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес пользователя!");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
