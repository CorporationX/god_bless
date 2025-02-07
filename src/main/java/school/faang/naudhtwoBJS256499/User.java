package school.faang.naudhtwoBJS256499;

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

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isBlank()
                || age < 18
                || !VALID_JOBS.contains(workplace)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect data entered"); //перевод Введены неверные данные
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("User: name- %s, age- %d, workplace- %s, address- %s",
                this.getName(), this.getAge(), this.getWorkplace(), this.getAddress());
    }
}
