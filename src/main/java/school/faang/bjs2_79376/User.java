package school.faang.bjs2_79376;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        try {
            if (name == null || name.equals("")) {
                throw new IllegalArgumentException("Имя не может быть null");
            }
            if (age < 18) {
                throw new IllegalArgumentException("Возраст < 18");
            }
            if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Такой работы нет");
            }
            if (!VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Такого адресса нет");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
