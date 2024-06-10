package faang.school.godbless.BJS2_7877;

import lombok.ToString;
import java.util.Set;

@ToString
public class User {

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final Integer age;
    private final String work;
    private final String address;

    public User(String name, Integer age, String work, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Пользователь не ввёл имя");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Пользователю меньше 18 лет");
        }
        if (VALID_JOBS.stream().noneMatch(work::equalsIgnoreCase)) {
            throw new IllegalArgumentException("Не работает в" + VALID_JOBS);
        }
        if (VALID_ADDRESSES.stream().noneMatch((address::equalsIgnoreCase))) {
            throw new IllegalArgumentException("Не живёт в" + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;

    }
}

