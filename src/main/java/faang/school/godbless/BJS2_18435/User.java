package faang.school.godbless.BJS2_18435;

import java.util.Set;

public record User(String name, int age, String workPlace, String address) {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User {
        validateName(name);
        validateAge(age);
        validateWorkPlace(workPlace);
        validateAddress(address);
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
    }

    private void validateWorkPlace(String workPlace) {
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Work place must be contained in the VALID_JOBS set");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address must be contained in the VALID_ADDRESSES set");
        }
    }
}
