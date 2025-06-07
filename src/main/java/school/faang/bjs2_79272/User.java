package school.faang.bjs2_79272;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;


    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст должен быть не меньше " + MIN_AGE + " лет");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("недопустимая работа " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("недопустимый адрес " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
