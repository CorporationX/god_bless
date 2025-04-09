package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или не заданным");
        }
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException("Возраст пользователя не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "User[name=%s, age=%d, job=%s, address=%s]",
                name, age, job, address);
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("DONAT", 23, "Uber", "Amsterdam"));
        users.add(new User("POLAND", 24, "Uber", "London"));
        users.add(new User("RICKY", 22, "Uber", "Amsterdam"));
        users.add(new User("ABBY", 19, "Amazon", "Amsterdam"));
        users.add(new User("DUCK", 100, "Uber", "Amsterdam"));
        users.add(new User("POLICY", 55, "Google", "New York"));
        users.add(new User("SAX", 33, "Google", "New York"));
        users.add(new User("BOLT", 21, "Google", "London"));
        users.add(new User("QWERTY", 22, "Amazon", "New York"));
        users.add(new User("ALIC", 18, "Amazon", "New York"));
        users.add(new User("ALEX", 19, "Amazon", "New York"));

        System.out.println(users);

    }
}
