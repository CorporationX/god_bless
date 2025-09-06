package school.faang.bjs2_85571;

import lombok.ToString;
import java.util.Set;

@ToString

public class User {
    public static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Пользователю должно быть не менее 18 лет");
        }
        if (!VALID_JOB.contains(job)) {
            throw new IllegalArgumentException("Допустимое место работы: Google, Uber или Amazon");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Допустимый адрес: London, New York или Amsterdam");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
