package school.faang.bjs2_85648_users_registration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес: " + address);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}