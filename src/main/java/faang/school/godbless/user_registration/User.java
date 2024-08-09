package faang.school.godbless.user_registration;

import java.util.Set;

public class User {
    private static final int MIN_AGE = 18;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (isValidData(name, age, job, address)) {
            System.out.println("Поля User заполнены некорректно! " + name);
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    private boolean isValidData(String name, int age, String job, String address) {
        return name.isBlank() || age < MIN_AGE
                || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address);
    }
}
