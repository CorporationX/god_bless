package faang.school.godbless.second_solution;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String job;
    private String address;

    public static void main(String[] args) {
        User user1 = new User("Vadim", 22, "Uber", "London");
    }

    public User(String name, int age, String job, String address) {
        validateUserFields(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void validateUserFields(String name, int age, String job, String address) {
        if (name.isEmpty() && name == null) {
            throw new IllegalArgumentException("Отсутствует имя");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Нет 18 лет");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Места работы нет в списке");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адреса нет в списке");
        }
    }
}