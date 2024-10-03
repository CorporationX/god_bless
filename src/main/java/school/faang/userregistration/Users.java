package school.faang.userregistration;

import java.util.HashSet;
import java.util.Set;

public class Users {
    private String name;
    private Integer age;
    private String workPlace;
    private String address;
    private final Integer MIN_AGE = 18;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New-York", "Amsterdam");

    public Users(String name, int age, String workPlace, String address) {
        this.name = nameValidation(name);
        this.age = ageValidation(age);
        this.workPlace = workPlaceValidation(workPlace);
        this.address = addressValidation(address);
    }

    private String nameValidation(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            return this.name = name;
        }
    }

    private Integer ageValidation(Integer age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else {
           return this.age = age;
        }
    }

    private String workPlaceValidation(String workPlace) {
        boolean logicValue = false;
        for (String element : VALID_JOBS) {
            if (element.contains(workPlace)) {
                logicValue = true;
            }
        }
        if (!logicValue) {
            throw new IllegalArgumentException("Этого элемента workPlace нет в сэте");
        }
        return workPlace;
    }

    private String addressValidation(String address) {
        boolean logicValue = false;
        for (String element : VALID_ADDRESSES) {
            if (element.contains(address)) {
                logicValue = true;
            }
        }
        if (!logicValue) {
            throw new IllegalArgumentException("Этого элемента address нет в сэте");
        }
        return address;
    }
}
