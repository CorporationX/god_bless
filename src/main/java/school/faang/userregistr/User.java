package school.faang.userregistr;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@EqualsAndHashCode
@ToString
@Setter
@Getter
public class User {

    public static final int LIMIT_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(@NonNull String name, int age, @NonNull String job, @NonNull String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Некорректно введено имя пользователя");
        }
        if (age < LIMIT_AGE) {
            throw new IllegalArgumentException("Пользователь слишком мал для такого, вход 18+");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Неподходящее место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Неподходящий адрес пользователя");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}