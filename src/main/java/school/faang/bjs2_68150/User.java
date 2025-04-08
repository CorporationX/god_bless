package school.faang.bjs2_68150;

import java.text.MessageFormat;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS =
            Set.of("Google".toLowerCase(), "Uber".toLowerCase(), "Amazon".toLowerCase());
    private static final Set<String> VALID_ADDRESSES =
            Set.of("London".toLowerCase(), "New York".toLowerCase(), "Amsterdam".toLowerCase());
    private static final int MIN_VALID_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Введите имя");
        }
        if (age >= MIN_VALID_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException(MessageFormat.format("Регистрировать можно с {0} лет", MIN_VALID_AGE));
        }
        if (VALID_JOBS.contains(job.toLowerCase())) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("Недопустимое место работы");
        }
        if (VALID_ADDRESSES.contains(address.toLowerCase())) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Недопустимый адрес");
        }
    }
}
