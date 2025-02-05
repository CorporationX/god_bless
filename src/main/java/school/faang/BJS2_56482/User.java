package school.faang.BJS2_56482;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    private void validName() {
        if (this.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
    }

    private void validAge() {
        if (this.getAge() < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18!");
        }
    }

    private void validJobs() {
        if (!VALID_JOBS.contains(this.getJob())) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
    }

    private void validAddress() {
        if (!VALID_ADDRESSES.contains(this.getAddress())) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
    }

    public void validInformation() {
        validName();
        validAge();
        validJobs();
        validAddress();
    }
}
