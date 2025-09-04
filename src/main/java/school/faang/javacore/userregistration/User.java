package school.faang.javacore.userregistration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.function.Predicate;

@Getter
@Setter
@ToString
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static final int AGE_THRESHOLD = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validateField(name,
                String::isBlank,
                "Имя не может быть пустым");
        validateField(age,
                value -> value < AGE_THRESHOLD,
                "Возраст не может быть меньше " + AGE_THRESHOLD);
        validateField(job,
                value -> !VALID_JOBS.contains(value),
                "Место работы должно содержаться в наборе: " + VALID_JOBS);
        validateField(address,
                value -> !VALID_ADDRESSES.contains(value),
                "Адрес должен содержаться в наборе: " + VALID_ADDRESSES);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private <T> void validateField(
            T value,
            Predicate<T> validation,
            String exceptionMessage
    ) throws IllegalArgumentException, NullPointerException {
        if (value == null) {
            throw new NullPointerException("Не надо передавать null!");
        } else if (validation.test(value)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}