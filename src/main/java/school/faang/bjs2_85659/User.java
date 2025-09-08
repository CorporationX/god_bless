package school.faang.bjs2_85659;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("имя не должно быть пустым");
        } else {
            this.name = name;
        }

        if (age < 18) {
            //System.err.println("возраст не может быть меньше 18");
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        } else {
            this.age = age;
        }

        if (VALID_JOBS.contains(job)) {
            this.job = job;
        } else {
            throw new IllegalArgumentException("недопустимое место работы");
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("недопустимый город");
        }
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job=" + job +
                ", address=" + address +
                '}';
    }
}
