package school.faang.bjs2_68375.user_registration;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final String NULL_NAME = "Имя не может быть пустым.";
    private static final String AGE_LESS_THAN_18 = "Возраст не может быть меньше 18.";
    private static final String NOT_VALID_JOB = "Место работы должно содержаться в наборе VALID_JOBS.";
    private static final String NOT_VALID_ADDRESS = "Место работы должно содержаться в наборе VALID_ADDRESSES.";

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NULL_NAME);
        }
        if (age < 18) {
            throw new IllegalArgumentException(AGE_LESS_THAN_18);
        }
        if (job == null || job.isEmpty() || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(NOT_VALID_JOB);
        }
        if (address == null || address.isEmpty() || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(NOT_VALID_ADDRESS);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
