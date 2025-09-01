package school.faang.bjs2_85490;

import java.util.Arrays;

public class User {
    private static final String[] VALID_JOBS = { "Google", "Uber", "Amazon" };
    private static final String[] VALID_ADDRESSES = { "London", "New York", "Amsterdam" };
    private static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {

        validateParams(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateParams(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MIN_AGE);
        }

        if (job == null || !Arrays.asList(VALID_JOBS).contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе: "
                + Arrays.toString(VALID_JOBS));
        }

        if (address == null || !Arrays.asList(VALID_ADDRESSES).contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе: "
                + Arrays.toString(VALID_ADDRESSES));
        }
    }
}
