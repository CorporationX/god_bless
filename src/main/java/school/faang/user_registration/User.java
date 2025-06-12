package school.faang.user_registration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Нет имени");
        } else if (age < MIN_AGE) {
            throw new IllegalArgumentException(name + " вы не прошли валидацию: Возраст менее 18 лет");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(name + " вы не прошли валидацию: Нет такой организации");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(name + " вы не прошли валидацию: Нет такого города");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}
