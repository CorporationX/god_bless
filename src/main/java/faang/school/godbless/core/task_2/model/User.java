package faang.school.godbless.core.task_2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_THRESHOLD = 18;

    private final String name;
    @EqualsAndHashCode.Include
    private final int age;
    @EqualsAndHashCode.Include
    private final String job;
    @EqualsAndHashCode.Include
    private final String address;

    public User(String name, int age, String job, String address) {
        validateUserFields(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateUserFields(String name, int age, String job, String address) {
        if (name.isBlank() || age < AGE_THRESHOLD || !VALID_JOBS.contains(job)
                || !VALID_ADDRESSES.contains(address)) {
            log.error("При создании пользователя произошла ошибка. Необходимо проверить поля на соответствие ограничениям");
            throw new IllegalArgumentException("Ошибка при инициализации пользователя");
        }
    }
}