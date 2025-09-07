package school.faang.userregistration;

import java.util.Set;

import lombok.ToString;
import lombok.NonNull;
import lombok.Getter;

@ToString
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(@NonNull String name, @NonNull int age, @NonNull String workplace, @NonNull String address)
            throws IllegalAccessException {
        if (name.isBlank()) {
            throw new IllegalAccessException((name + " " + "имя не может быть пустым"));
        }
        if (age < 18) {
            throw new IllegalAccessException(name + " " + "Возраст не может быть меньше 18");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalAccessException((name + " " + "Адрес может быть только: " + VALID_ADDRESSES));
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalAccessException((name + " " + "Место работы может быть только таким: " + VALID_JOBS));
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}
