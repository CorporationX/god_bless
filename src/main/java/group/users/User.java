package group.users;

import java.util.Set;

import lombok.Data;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (VALID_JOBS.contains(workplace)) {
            this.workplace = workplace;
        } else {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве");
        }
    }
}