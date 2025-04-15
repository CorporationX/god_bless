package school.faang.sprintone.userregistration;

import lombok.Data;

import java.util.Optional;
import java.util.Set;

@Data
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name не может быть null или пустым!");
        }
        this.name = name;

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст должен быть больше %d".formatted(MIN_AGE));
        }
        this.age = age;

        this.job = Optional.of(job).filter(VALID_JOBS::contains)
                .orElseThrow(() -> new IllegalArgumentException("Не верно указана работа. " +
                        "Работа должна быть в белом списке."));

        this.address = Optional.of(address).filter(VALID_ADDRESSES::contains)
                .orElseThrow(() -> new IllegalArgumentException("Не верно указан адрес. " +
                        "Адрес должен быть в нашем списке."));
    }
}
