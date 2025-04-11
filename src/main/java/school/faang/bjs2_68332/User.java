package school.faang.bjs2_68332;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше %d".formatted(MIN_AGE));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Если вы работаете не в %s - вы нам не подходите".formatted(VALID_JOBS));
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                    "Если вы живете не в %s - вы нам не подходите".formatted(VALID_ADDRESSES));
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
