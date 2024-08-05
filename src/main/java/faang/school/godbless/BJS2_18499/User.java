package faang.school.godbless.BJS2_18499;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeJob;
    private String address;

    private static final Set VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeJob, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(placeJob) || !VALID_ADDRESSES.contains(address) ) {
            throw new IllegalArgumentException("Ошибка");
        } else {
            this.name = name;
            this.age = age;
            this.placeJob = placeJob;
            this.address = address;
        }
    }
}
