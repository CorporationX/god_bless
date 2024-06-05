package faang.school.godbless;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        this.name = nameCheck(name);
        this.age = ageCheck(age);
        this.work = workCheck(work);
        this.address = addressCheck(address);
    }

    private String nameCheck(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        return name;
    }

    private int ageCheck(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
        return age;
    }

    private String workCheck(String work) throws IllegalArgumentException {
        if (work == null || work.isBlank()) {
            throw new IllegalArgumentException("Work cannot be blank");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Work address must be valid");
        }
        return work;
    }

    private String addressCheck(String address) throws IllegalArgumentException {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address address must be valid");
        }
        return address;
    }
}