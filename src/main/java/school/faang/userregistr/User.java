package school.faang.userregistr;

import lombok.Setter;
import lombok.Getter;
import java.util.List;

@Getter
@Setter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;
    private static List<String> VALID_JOBS = List.of("Google","Uber","Amazon");
    private static List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static int VALID_AGE = 18;

    public User(String name, int age, String job, String address) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Поле имя не может быть пустым");
        } else if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возрастное ограничение 18+");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Некорректное место работы");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
