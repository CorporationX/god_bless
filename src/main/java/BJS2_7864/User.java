package BJS2_7864;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int LEGAL_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;


    public User(String name, int age, String workPlace, String address) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым !");
        }
        this.name = name;

        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18 !");
        }
        this.age = age;

        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Место работы должно быть из списка разрешенных !");
        }
        this.workPlace = workPlace;

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть из списка разрешенных !");
        }
        this.address = address;
    }

}