package faang.school.godbless.register_user;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}