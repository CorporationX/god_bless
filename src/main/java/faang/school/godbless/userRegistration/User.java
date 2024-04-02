package faang.school.godbless.userRegistration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        if(age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }

        if(!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("неизвестное место работы");
        }

        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("неизвестный адрес");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
