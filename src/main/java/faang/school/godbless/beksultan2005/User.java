package faang.school.godbless.beksultan2005;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;
    Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new java.lang.IllegalArgumentException("name is empty");
        }
        if (age < 18) {
            throw new java.lang.IllegalArgumentException("age small 18");
        }
        if (!VALID_JOBS.contains(placeWork)) {
            throw new java.lang.IllegalArgumentException("Error");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new java.lang.IllegalArgumentException("Error");
        }
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }
}
