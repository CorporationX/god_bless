package faang.school.godbless.BJS2_4396;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );
    static final int AGE_LIMIT = 18;
    private String name;
    private int age;
    private String placeOfWork;
    private String address;


    public User(String name, int age, String placeOfWork, String address) {
        toValidate(name, age, placeOfWork, address);
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    private void toValidate(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (age >= AGE_LIMIT) {
            throw new IllegalArgumentException("age under 18");
        } else if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("job not on the list");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address not on the list");
        }
    }
}
