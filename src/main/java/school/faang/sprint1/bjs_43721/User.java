package school.faang.sprint1.bjs_43721;

import lombok.Getter;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_MIN = 18;
    private static final String CANNOT_BE_NULL = "Имя не может быть пустым";
    private static final String CANNOT_BE_LESS18 = "Возраст не может быть меньше 18";
    private static final String NOT_VALID_JOB = "Недопустимое место работы";
    private static final String NOT_VALID_ADDRESS = "Недопустимый адрес";

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {

        validationUserData(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void validationUserData(String name, int age, String job, String address) {

        if (name.isEmpty()) {
            throw new NullPointerException(CANNOT_BE_NULL);
        }
        if (age < AGE_MIN) {
            throw new IllegalArgumentException(CANNOT_BE_LESS18);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(NOT_VALID_JOB);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(NOT_VALID_ADDRESS);
        }

    }
}