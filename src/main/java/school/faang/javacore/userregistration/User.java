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

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validateField(name, value -> !value.isBlank(), "Имя не может быть пустым");
        validateField(age, value -> value >= 18, "Возраст не может быть меньше 18");
        validateField(job, VALID_JOBS::contains, "Место работы должно содержаться в наборе VALID_JOBS");
        validateField(address, VALID_ADDRESSES::contains, "Адрес должен содержаться в наборе VALID_ADDRESSES");
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
        } else if (!validation.test(value)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}