package school.faang;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int PERMISSION_AGE = 18;


    public User(String name, int age, String work, String address) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < PERMISSION_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе %s.".formatted(VALID_JOBS));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе %s.".formatted(VALID_ADDRESSES));
        }

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;

    }
}
