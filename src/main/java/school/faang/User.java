package school.faang;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    Exception minAge = new Exception();

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле не заполнено");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть не меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Не подходящее место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не подходящий адрес");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}



