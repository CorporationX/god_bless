package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private int age;

    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String username, int age, String job, String address) {

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }

        if (job == null || !VALID_JOBS.contains(job)){
            throw new IllegalArgumentException("Invalid job");
        }

        if (address == null || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Invalid address");
        }
        this.username = username;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString(){
        return "Пользователь{" +
                "имя='" + username + '\'' +
                ", возраст=" + age +
                ", работа='" + job + '\'' +
                ", адрес='" + address + '\'' +
                '}';
    }
}
