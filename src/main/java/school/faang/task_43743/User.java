package school.faang.task_43743;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (validationUser(name, age, workplace, address)) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }

    private boolean validationUser(String name, int age, String workplace, String address) {
        if (name == null) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MINIMUM_AGE);
        }

        if (VALID_JOBS.contains(workplace) == false) {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
        }

        if (VALID_ADDRESSES.contains(address) == false) {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", workplace='" + workplace
                + '\'' + ", address='" + address + '\'' + '}';
    }
}