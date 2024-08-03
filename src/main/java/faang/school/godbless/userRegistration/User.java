package faang.school.godbless.userRegistration;

import java.util.HashSet;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) throws IllegalArgumentException {
        if (name.trim().isEmpty()) {
            System.out.println("имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("место работы должно быть из списка");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("адрес должен содержаться в списке адресов");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
