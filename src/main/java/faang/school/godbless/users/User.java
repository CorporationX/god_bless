package faang.school.godbless.users;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;


@Getter
@Setter
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private int id;
    private String name;
    private int age;
    private Set<String> activity;
    private String address;
    private String placeOfWork;


    public User(int id, String name, int age, Set<String> activity, String address, String placeOfWork) {
        validations(name, age, address, placeOfWork);
        this.id = id;
        this.activity = activity;
        this.name = name;
        this.age = age;
        this.address = address;
        this.placeOfWork = placeOfWork;

    }

    void validations(String name, int age, String address, String placeOfWork) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Field name must be not null or empty!");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age must be less 18 year!");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                    "The address must contain one of the following cities: " +
                            "London, New York, Amsterdam."
            );
        } else if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException(
                    "The place of work must be one of the companies: " +
                            "Google, Uber, Amazon"
            );
        }
    }
}

