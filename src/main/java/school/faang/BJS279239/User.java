package school.faang.BJS279239;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть 18 или больше");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимая профессия: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не разрешён: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;



    }
}
