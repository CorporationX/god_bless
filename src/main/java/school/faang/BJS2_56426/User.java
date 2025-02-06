package school.faang.BJS2_56426;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;


    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    public User(String name, int age, String workPlace, String address) {
        validate(name, age, workPlace, address);

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private static void validate(String name, int age, String workPlace, String address) {
        List<String> errors = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            errors.add("Имя не может быть пустым");
        }

        if (age < VALID_AGE) {
            errors.add("Возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(workPlace)) {
            errors.add("Место работы должно содержаться в наборе VALID_JOBS");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            errors.add("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Ошибки валидации: \n" + String.join("\n", errors));
        }
    }

    @Override
    public String toString() {
        return String.format(
                """
                        ---------------------------
                        User Information:
                        Name     : %s
                        Age      : %d
                        WorkPlace: %s
                        Address  : %s
                        ---------------------------
                        """,
                name, age, workPlace, address
        );
    }
}
