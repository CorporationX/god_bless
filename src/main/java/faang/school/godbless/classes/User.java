package faang.school.godbless.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String jobLocate;
    private String address;

    private final Set<String> VALID_JOB = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New Yor", "Amsterdam"));

    public User(String name, int age, String jobLocate, String address){
        if ((name == null) || name.equals("")){
            throw new IllegalArgumentException("Имя не можеть быть быть пустым");
        }
        if (age < 18){
            throw new IllegalArgumentException("Вам должно быть 18 лет или больше");
        }
        if (!VALID_JOB.contains(address)){
            throw new IllegalArgumentException("В этом месте нет работы");
        }
        if (!VALID_ADDRESSES.contains(jobLocate)){
            throw new IllegalArgumentException("Такого места работы нет");
        }
        this.name = name;
        this.age = age;
        this.jobLocate = jobLocate;
        this.address = address;
    }
}
