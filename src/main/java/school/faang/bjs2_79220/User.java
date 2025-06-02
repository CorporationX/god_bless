package school.faang.bjs2_79220;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private int age;
    private String name;
    private String workplace;
    private String address;

    public User(int age, String name, String workplace, String address) {
        validate(age, name, workplace, address);
        this.age = age;
        this.name = name;
        this.workplace = workplace;
        this.address = address;
    }

    public void validate(int age, String name, String workplace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!User.VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Невалидное место работы должно");
        }
        if (!User.VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Невалидное место работы должно");
        }
    }
}
