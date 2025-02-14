package school.faang;

import java.util.Set;

public record User(String name, int age, String job, String address) {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < 18) {
            throw new IllegalArgumentException(String.format("Возраст не может быть меньше 18. Вы задали: %d", age));
        }

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format(
                    "Возможные места работы: %s. Вы задали: %s",
                    String.join(", ", VALID_JOBS),
                    job));
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format(
                    "Возможные адреса: %s. Вы задали: %s",
                    String.join(", ", VALID_ADDRESSES),
                    address));
        }
    }
}
