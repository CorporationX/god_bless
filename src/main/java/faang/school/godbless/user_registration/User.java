package faang.school.godbless.user_registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if(age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Возраст не должен быть меньше " + MINIMUM_AGE);
        } else if(!VALID_JOBS.contains(job)){
            throw new IllegalArgumentException("Не валидная работа");
        } else if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Не валидный адрес");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
