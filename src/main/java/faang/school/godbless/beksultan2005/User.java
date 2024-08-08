package faang.school.godbless.beksultan2005;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("age small 18");
        }
        if (!VALID_JOBS.contains(placeWork)) {
            throw new IllegalArgumentException("Error");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Error");
        }
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }
}
