package school.faang.bjs2_85544;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя пользователя не может быть null или пустым");
        }
        if (age <= 18) {
            throw new IllegalArgumentException("возраст пользователя меньше 18");
        }
        if (VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("вы здесь не работаете");
        }
        if (VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("вы здесь не живете");
        }

        this.address = address;
        this.job = job;
        this.age = age;
        this.name = name;
    }
}
