package school.faang.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    //принимает List из объектов User и возвращает Map, где ключом является возраст пользователя,
// а значением — список из всех пользователей в оригинальном списке, которые имеют соответствующий возраст.
    public static Map<Integer, List> groupUsers(List<User> users) {
        Map<Integer, List> userAge = new HashMap<>();
        List<User> ageUser = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            users.get(i).getAge();
        }
        return userAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

