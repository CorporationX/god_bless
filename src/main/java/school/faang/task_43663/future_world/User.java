package school.faang.task_43663.future_world;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public record User(String name, int age, String job, String address) {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MINIMUM_AGE = 18;

    public User(String name, int age, String job, String address) {
        List<String> errors = new ArrayList<>();

        if (name == null || name.isBlank()) {
            errors.add("Имя не может быть пустым.");
        }

        if (age < MINIMUM_AGE) {
            errors.add("Возраст не может быть меньше " + MINIMUM_AGE + " лет. Вы школьник: " + age);
        }

        if (!VALID_JOBS.contains(job)) {
            errors.add("Место работы '" + job + "' некорректный. Выберите из списка: " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            errors.add("Адрес '" + address + "' некорректный. Выберите из списка: " + VALID_ADDRESSES);
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", errors));
        }

        this.name = name.trim();
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
