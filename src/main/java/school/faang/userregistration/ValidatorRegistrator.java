package school.faang.userregistration;

import java.util.Set;

public class ValidatorRegistrator {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    public static void validate(User user) {
        if (user.getName().isBlank()) {
            throw new IllegalArgumentException("%s имя не может быть пустым".formatted(user.getName()));
        }
        if (user.getAge() < MIN_AGE) {
            throw new IllegalArgumentException("%s Возраст не может быть меньше 18".formatted(user.getName()));
        }
        if (!VALID_ADDRESSES.contains(user.getAddress())) {
            throw new IllegalArgumentException(("%s Адрес может быть только: %s".formatted(user.getName(),
                    VALID_ADDRESSES)));
        }
        if (!VALID_JOBS.contains(user.getWorkplace())) {
            throw new IllegalArgumentException(("%s Место работы может быть только таким: %s".formatted(user.getName(),
                    VALID_JOBS)));
        }
    }
}
