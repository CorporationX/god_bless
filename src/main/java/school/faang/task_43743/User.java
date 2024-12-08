package school.faang.task_43743;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        if (age > 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (VALID_JOBS.contains(workplace)) {
            this.workplace = workplace;
        } else {
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES.");
        }
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", workplace='" + workplace
                + '\'' + ", address='" + address + '\'' + '}';
    }
}
