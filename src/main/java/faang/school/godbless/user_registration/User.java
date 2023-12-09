package faang.school.godbless.user_registration;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work_place;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int MAX_AGE = 18;

    public User(String name, int age, String work_place, String address) {
        if (!name.isEmpty() && age >= MAX_AGE && VALID_JOBS.contains(work_place) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.work_place = work_place;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work_place='" + work_place + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
