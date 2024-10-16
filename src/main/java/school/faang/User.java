package school.faang;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int MINIMUM_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        checkVariables();

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkVariables() {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        }
    }
}
