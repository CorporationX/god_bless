package faang.school.godbless.user_registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    public static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if(name == null ){
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if(age < 18) {
            throw new IllegalArgumentException("Возраст не должен быть меньше 18");
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
