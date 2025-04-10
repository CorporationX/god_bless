package school.faang.bjs268324;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {

    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("User cannot be under 18");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Not valid workplaces");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Not valid address");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }
}
