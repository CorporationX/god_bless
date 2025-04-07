package school.faang.userregistr;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Setter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("некорректно введено имя пользователя");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Пользователь слишком мал для такого, вход 18+");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Неподходящее место работы");
        }
        if (!VALID_ADDRESSES.contains(job)) {
            throw new IllegalArgumentException("Неподходящее место работы");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}


