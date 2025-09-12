package school.faang.user.reg;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int MIN_AGE = 18;


    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Поле не заполнено");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст должен быть не меньше: " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Не подходящее место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не подходящий адрес");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}