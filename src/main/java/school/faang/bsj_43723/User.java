package school.faang.bsj_43723;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    static final int MIN_AGE = 18;
    String name;
    int age;
    String job;
    String address;

    public User(String name, int age, String job, String address) {

        if (validateAllFields(name, age, job, address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Не корректные параметры пользователя");
        }

    }

    private boolean validateAllFields(String name, int age, String job, String address) {
        return validateName(name) && validateAge(age) && validateJob(job) && validateAddress(address);
    }

    private boolean validateName(String name) {
        return name != null && !name.isEmpty();
    }

    private boolean validateAge(int age) {
        return age >= MIN_AGE;
    }

    private boolean validateJob(String job) {
        return VALID_JOBS.contains(job);
    }

    private boolean validateAddress(String address) {
        return VALID_ADDRESSES.contains(address);
    }
}
