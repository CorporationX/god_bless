package school.faang;

import java.util.Set;

public class User {

    private static final int AGE_LIMIT = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String>  VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    String name;
    int age;
    String placeOfWork;
    String address;

    public User(String name, int age, String placeOfWork, String address) {

        validate(name, age, placeOfWork, address);

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    private void validate(String name, int age, String placeOfWork, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Incorrect name");
        }

        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException(String.format("Age must be over %d", AGE_LIMIT));
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Wrong corporation");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong address");
        }
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'';
    }
}
