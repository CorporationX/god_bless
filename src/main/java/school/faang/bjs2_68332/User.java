package school.faang.bjs2_68332;

import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Если вы работаете не в " + VALID_JOBS + " - вы нам не подходите");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Если вы живете не в " + VALID_ADDRESSES + " - вы нам не подходите");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }
}
