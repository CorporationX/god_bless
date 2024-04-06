package faang.school.godbless.BJS2_4213;
import java.util.Set;


public class Task2 {
    public static void main(String[] args) {
        User user1 = new User("Miha",23,"Google","London");
    }

}
class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }

}




