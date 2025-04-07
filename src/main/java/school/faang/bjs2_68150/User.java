package school.faang.bjs2_68150;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS;
    private static final Set<String> VALID_ADDRESSES;

    static {
        VALID_JOBS = Set.of("Google".toLowerCase(), "Uber".toLowerCase(), "Amazon".toLowerCase());
        VALID_ADDRESSES = Set.of("London".toLowerCase(), "New York".toLowerCase(), "Amsterdam".toLowerCase());
    }

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
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Недопустимый возраст для регистрации");
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
