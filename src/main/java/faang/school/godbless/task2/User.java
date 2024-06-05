package faang.school.godbless.task2;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (check(name, age, workplace, address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }
    public boolean check(String name, int age, String workplace, String address) {
        return name.isEmpty() || age < MIN_AGE ||
                !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address);
    }
}