package faang.school.godbless.task_2;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        if (age < 18) throw new IllegalArgumentException("Only 18+");
        if (!VALID_JOBS.contains(company)) throw new IllegalArgumentException("Try harder");
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Never give up");

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }
}
