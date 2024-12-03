package school.faang.task_43655;

import lombok.ToString;
import java.util.Set;

@ToString
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    public User(String name, int age, String job, String address) {

        if (name.isBlank()) {
            throw new IllegalArgumentException("Поле имя не может быть пустым");
        }
        if (age > VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше" + VALID_AGE);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы указано не верно");
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Адрес указан неверно");

        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

}