package school.faang.task43662;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int AGE_LIMIT = 18;

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }

        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Возраст должен быть не меньше " + AGE_LIMIT + " лет.");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Указанная профессия недопустима. Выберите из списка разрешенных.");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Указанный адрес недопустим. Проверьте список разрешенных адресов.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}