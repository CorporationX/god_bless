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

    public User(String name, int age, String workPlace, String address) {
        List<String> errors = new ArrayList<>();

        validName(name, errors);
        validAge(age, errors);
        validWorkPlace(workPlace, errors);
        validAddress(address, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Ошибки валидации: \n" + String.join("\n", errors));
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private static String validName(String name, List<String> errors) {
        if (name == null || name.trim().isEmpty()) {
            errors.add("Имя не может быть пустым");
        }
        return name;
    }

    private static int validAge(int age, List<String> errors) {
        if (age < 18) {
            errors.add("Возраст не может быть меньше 18");
        }
        return age;
    }

    private static String validWorkPlace(String workPlace, List<String> errors) {
        if (!VALID_JOBS.contains(workPlace)) {
            errors.add("Место работы должно содержаться в наборе VALID_JOBS");
        }
        return workPlace;
    }

    private static String validAddress(String address, List<String> errors) {
        if (!VALID_ADDRESSES.contains(address)) {
            errors.add("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
        return address;
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
