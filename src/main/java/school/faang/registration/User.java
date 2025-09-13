package school.faang.registration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York");
    public static final int MIN_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в VALID_JOBS");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в VALID_ADDRESSES");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
