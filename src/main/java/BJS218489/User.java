package BJS218489;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data

public class User {
    private String name;
    private int age;
    private String work;
    private String adress;

    public User(String name, int age, String work, String adress) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupList(List<User> users) { //создан метод принимающий список User и возвращающий Hashmap
        Map<Integer, List<User>> people = new HashMap<>(); //создан HashMap принимающий возраст - ключ и список User - значение. Он будет возвращен.
        for (User person : users) { // for - each перебирает список User
            if (people.containsKey(person.age)) { // если в HashMap содержится возраст User,то
                people.get(person.age).add(person); // добавляем User в HashMap с его ключом
            } else {
                people.put(person.age, new LinkedList<>(List.of(person))); //создаем список с новым возрастом-ключем
            }
        }
        return people;
    }
}
