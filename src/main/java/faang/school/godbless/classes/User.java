package faang.school.godbless.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String company;
    private String location;

    private final Set<String> VALID_JOB = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String company, String location) {
        if (isValidate(name, age, company, location)) {
            this.name = name;
            this.age = age;
            this.company = company;
            this.location = location;
        }
    }

    private boolean isValidate(String name, int age, String company, String location) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Имя не можеть быть быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Вам должно быть 18 лет или больше");
        }
        if (!VALID_JOB.contains(company)) {
            throw new IllegalArgumentException("Такого места работы нет");
        }
        if (!VALID_ADDRESSES.contains(location)) {
            throw new IllegalArgumentException("В этом месте нет работы");
        }
        return true;
    }
}
