package school.faang.bjs2_79256;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int PASSING_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не должно быть пустым");
        }
        if (age < PASSING_AGE) {
            throw new IllegalArgumentException("ваш не должен быть меньше: " + PASSING_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("недопустимое место работы: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("недопустимый адрес: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
