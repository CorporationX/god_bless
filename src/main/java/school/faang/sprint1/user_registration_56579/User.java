package school.faang.sprint1.user_registration_56579;

import lombok.NonNull;

import java.util.Set;

public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_LEGAL_AGE = 18;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(@NonNull String name, @NonNull int age, @NonNull String job, @NonNull String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("Имя не может быть пустым " +
                    "или состоять из пробелов " + name));
        }
        if (age < MIN_LEGAL_AGE) {
            throw new IllegalArgumentException(String.format("Возраст не может быть меньше %d", MIN_LEGAL_AGE));
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("Место работы %s не содержится " +
                    "в списке допустимых значений: %s", job, VALID_JOBS));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format("Адрес %s не содержится " +
                    "в списке допустимых значений: %s", address, VALID_ADDRESSES));
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
