package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@EqualsAndHashCode
@Setter
@Getter
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static int idNum = 0;
    private int id;
    private String name;
    private int age;
    private Set<String> activity;
    private String placeOfWork, address;

    User(String name, int age, Set<String> activity) {
        setId(idNum++);
        setActivity(activity);
        setAge(age);
        setName(name);
    }
  
    User(String name, String placeOfWork, String address, int age) {
        validation(name, placeOfWork, address, age);
        if (name == null || name.isEmpty() || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.placeOfWork = placeOfWork;
        this.age = age;
        this.address = address;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> userActivity = new HashMap<>();

        for (User usFor : users) {
            for (String activUsFor : usFor.activity) {
                    if (activity.contains(activUsFor)) {
                        userActivity.put(usFor, activUsFor);
                        break;
                    }
                }
            }
        return userActivity;
    }

    private void validation(String name, String placeOfWork, String address, int age) {
        if (name == null || name.isEmpty()) {
            System.out.println("Введено не корректное имя");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            System.out.println("Введено некорректное место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            System.out.println("Введен некорректный адрес");
        }
        if (age<18)
        {
            System.out.println("Пользователи с возрастом меньше 18 не допускаются к регистрации");
        }
    }

    
}