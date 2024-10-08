package userregistration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_OF_MAJORITY = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (age < AGE_OF_MAJORITY) {
            throw new IllegalArgumentException();
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException();
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}
