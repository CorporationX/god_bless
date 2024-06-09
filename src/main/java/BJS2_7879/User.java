package BJS2_7879;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
@Data
public class User {
    private final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Error: name is null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Error: name is empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("not 18 years old");
        }
        if (!VALID_JOB.stream().anyMatch(placeOfWork::equalsIgnoreCase)) {
            throw new IllegalArgumentException("Doesn't work here: " + VALID_JOB);
        }
        if (!(VALID_ADDRESSES.stream().anyMatch(address::equalsIgnoreCase))) {
            throw new IllegalArgumentException("Not from:  " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
