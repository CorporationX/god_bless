package school.faang.sprint1.task_BJS2_56334;

import java.util.Set;

/*
Для тестов
src/test/school.faang.sprint1.task_BJS2_56334/UserTest
*/

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age,
                String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("не валидное имя - " + name);
        }
        if (age < 18) {
            throw new IllegalArgumentException("не валидный возраст - " + age);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("не валидный адрес - " + address);
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("не валидная работа - " + job);
        }

        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }
}
