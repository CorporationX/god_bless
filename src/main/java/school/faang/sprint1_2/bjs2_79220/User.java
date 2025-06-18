package school.faang.sprint1_2.bjs2_79220;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_VALID_AGE = 18;

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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MIN_VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_VALID_AGE);
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Невалидное место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Невалидный адрес работы");
        }
    }
}
