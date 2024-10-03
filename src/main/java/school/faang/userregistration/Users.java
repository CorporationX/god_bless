package school.faang.userregistration;

import java.util.HashSet;
import java.util.Set;

public class Users {
    private String name;
    private Integer age;

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New-York", "Amsterdam");

    public Users(String name, int age) {
        this.name = nameValidation(name);
        this.age = ageValidation(age);
        setValidation();
    }

    private String nameValidation(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            return this.name = name;
        }
    }

    private Integer ageValidation(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else {
           return this.age = age;
        }
    }

    private void setValidation() {
        if (VALID_JOBS.isEmpty()) {
            throw new IllegalArgumentException("Set VALID_JOBS пустой");
        }

        if (VALID_ADDRESSES.isEmpty()) {
            throw new IllegalArgumentException("Set VALID_ADDRESSES пустой");
        }
    }
}
