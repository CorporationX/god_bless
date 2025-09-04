package school.faang.bjs2_85544;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    private static void validateUser(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя пользователя не может быть null или пустым");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("возраст пользователя меньше " + VALID_AGE);
        }
        if (VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("вы здесь не работаете, вы можете работать только в " + VALID_JOBS);
        }
        if (VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("вы здесь не живете, вы можете жить только в " + VALID_ADDRESS);
        }
    }

    public User(String name, int age, String job, String address) {
        validateUser(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
