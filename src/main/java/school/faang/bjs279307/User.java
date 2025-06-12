package school.faang.bjs279307;

import java.util.Set;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final int MIN_AGE = 18;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле имя не должно быть пустым.");
        }
        this.name = name;

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст должен быть " + MIN_AGE + " или старше.");
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Вы должны работать в: " + job);
        }
        this.job = job;

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть одним из: " + VALID_ADDRESS);
        }
        this.address = address;
    }
}