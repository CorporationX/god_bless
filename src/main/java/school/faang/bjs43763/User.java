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

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) throws IllegalArgumentException {

        if (!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name should not be empty!");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age should be more than 18!");
        } else {
            this.age = age;
        }

        for (var validJob : VALID_JOBS) {
            if (workplace.contains(validJob)) {
                this.workplace = workplace;
                break;
            }
        }
        if (this.workplace == null) {
            throw new IllegalArgumentException("Name of organization should be valid!");
        }

        for (var validAddress : VALID_ADDRESSES) {
            if (address.contains(validAddress)) {
                this.address = address;
                break;
            }
        }
        if (this.address == null) {
            throw new IllegalArgumentException("City should be valid!");
        }
    }
}