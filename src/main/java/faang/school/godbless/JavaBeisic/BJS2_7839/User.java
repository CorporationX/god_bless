package faang.school.godbless.JavaBeisic.BJS2_7839;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым" + ": " + name);
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18" + ": " + name);
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Место работы должно содержаться в множестве VALID_JOBS" + ": " + name);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в множестве VALID_ADDRESSES" + ": " + name);
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
