package faang.school.godbless.registration;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private final Integer age;
    private String work;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String work, String address) {
        validate(name, age, work, address);

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public void validate(String name, Integer age, String work, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Место работы должно содержаться в заданном множестве");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в заданном множестве");
        }
    }
}
