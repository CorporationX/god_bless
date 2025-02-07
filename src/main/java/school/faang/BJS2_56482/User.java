package school.faang.BJS2_56482;

import java.util.Set;

import lombok.NonNull;

@NonNull
public record User(String name, int age, String job, String address) {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MINEMUM_AGE = 18;

    public User {
        validateName(name);
        validateAge(age);
        validateAddress(address);
        validateJobs(job);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
    }

    private static void validateAge(int age) {
        if (age < MINEMUM_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18!");
        }
    }

    private static void validateJobs(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть одним из этих компаний: (Google,Uber,Amazon");
        }
    }

    private static void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть одним из этих городов: London, New York, Amsterdam");
        }
    }
}