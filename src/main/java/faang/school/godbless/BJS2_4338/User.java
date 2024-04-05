package faang.school.godbless.BJS2_4338;

import lombok.Data;
import java.util.*;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        CheckUserParameters(name, age, workPlace, address);

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    private void CheckUserParameters(String name, int age, String workPlace, String address){
        if (name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18){
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("Место работы отсутствует во множестве");
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Адрес отсутствует во множестве");
        }
    }
}
