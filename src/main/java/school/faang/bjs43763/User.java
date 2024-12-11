package school.faang.bjs43763;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) throws IllegalArgumentException {
        if (validateUser(name, age, workplace, address)) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }

    private boolean validateUser(String name, int age, String workplace, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name should not be empty!");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age should be more than 18!");
        }

        if (VALID_JOBS.stream().noneMatch(workplace::contains)) {
            throw new IllegalArgumentException("Not valid organization!");
        }

        if (VALID_ADDRESSES.stream().noneMatch(address::contains)) {
            throw new IllegalArgumentException("Not valid city!");
        }

        return true;
    }
}