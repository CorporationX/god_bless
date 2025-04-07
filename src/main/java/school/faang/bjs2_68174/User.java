package school.faang.bjs2_68174;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("google", "uber", "amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("london", "new york", "amsterdam");
    private static final Integer MIN_AGE = 18;

    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    public User(String name, Integer age, String job, String address) {
        StringBuilder errors = new StringBuilder();
        if (name == null || name.isBlank()) {
            errors.append("Имя не может быть пустым;");
        }
        if (age < MIN_AGE) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Возраст не может быть меньше %s;".formatted(MIN_AGE));
        }
        if (!VALID_JOBS.contains(job.toLowerCase())) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Место работы должно содержаться в наборе %s;".formatted(VALID_JOBS));
        }
        if (!VALID_ADDRESSES.contains(address.toLowerCase())) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Адрес должен содержаться в наборе %s;".formatted(VALID_ADDRESSES));
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
