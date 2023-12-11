package faang.school.godbless.user_registration;

import java.util.Set;

public class User {
    private final static int MIN_AGE = 18;
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(String name, int age, String work_place, String address) {
        if (name != null || !name.isEmpty() && age >= MIN_AGE && VALID_JOBS.contains(work_place) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workPlace = work_place;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Incorrect validation");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work_place='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
