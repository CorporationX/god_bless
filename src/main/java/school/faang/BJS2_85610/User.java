package school.faang.BJS2_85610;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int ALLOWED_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < ALLOWED_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + ALLOWED_AGE);
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
