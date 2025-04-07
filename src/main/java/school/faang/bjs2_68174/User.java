package school.faang.bjs2_68174;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("google", "uber", "amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("london", "new york", "amsterdam");

    private final String name;
    private final Integer age;
    private final String job;
    private final String address;

    public User(String name, Integer age, String job, String address) {
        StringBuilder errors = new StringBuilder();
        if (name.isBlank()) {
            errors.append("Имя не может быть пустым;");
        }
        if (age < 18) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Возраст не может быть меньше 18;");
        }
        if (!VALID_JOBS.contains(job.toLowerCase())) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Место работы должно содержаться в наборе VALID_JOBS;");
        }
        if (!VALID_ADDRESSES.contains(address.toLowerCase())) {
            if (!errors.isEmpty()) {
                errors.append(" ");
            }
            errors.append("Адрес должен содержаться в наборе VALID_ADDRESSES;");
        }
        if (errors.isEmpty()) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException(errors.toString());
        }
    }

    public static User createUser(String name, Integer age, String job, String address) {
        User user = null;
        try {
            user = new User(name, age, job, address);
        } catch (RuntimeException e) {
            System.out.printf("Ошибка создания пользователя: %s\n", e);
        }
        return user;
    }

    public static void main(String[] args) {
        User ivan = createUser("Ivan", 30, "uber", "London");
        User nonameUser = createUser("", 10, "Uber", "Amsterdam");
        User stepan = createUser("Stepan", 10, "Uber", "London");
        User john = createUser("John", 41, "Yahoo!", "Berlin");
    }

}
