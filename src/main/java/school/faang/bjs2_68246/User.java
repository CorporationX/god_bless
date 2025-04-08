package school.faang.bjs2_68246;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public static final Set<String> COMPANY_NAMES = Set.of(
            "Google",
            "Apple",
            "Microsoft",
            "Amazon",
            "Netflix"
    );
    public static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    protected User(String name, Integer age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name: " + name);
        }

        if (age < 18) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }

        if (!COMPANY_NAMES.contains(job)) {
            throw new IllegalArgumentException(
                "Invalid job: \"" + job + "\". " +
                "The job must be one of the following: " +
                String.join(", ", COMPANY_NAMES)
            );
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(
                "Invalid address: \"" + address + "\". " +
                "The address must be one of the following: " +
                String.join(", ", VALID_ADDRESSES)
            );
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("{name: '%s', age: %d, job: '%s', address: '%s'}",
                name, age, job, address);
    }
}
