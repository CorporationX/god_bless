package BJS2_18537;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class User {
    //Поправил модификаторы на private
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    //Переписал с computeIfAbsent сложнее для понимания пока . но вроде все корректно
    //работает и кода в разы меньше! Спасибо
    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> resultMap = new HashMap<>();

        for (User user : users) {
            resultMap.computeIfAbsent(user.getAge(), x -> new ArrayList<>());
            resultMap.get(user.getAge()).add(user);
        }

        return resultMap;
    }

    //добавил геттер по полю age
    public int getAge() {
        return age;
    }
}
