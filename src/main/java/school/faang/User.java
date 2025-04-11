package school.faang;

import lombok.Setter;
import lombok.Getter;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;
    private static ArrayList<String> VALID_JOBS =new ArrayList<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static ArrayList<String> VALID_ADDRESSES = new ArrayList<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
        try {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Поле имя не может быть пустым");
            }
            else if (age < 18) {
                throw new IllegalArgumentException("Возрастное ограничение 18+");
            }
            else if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Некорректное место работы");
            }
            else if (!VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("Некорректный адрес");
            }
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
