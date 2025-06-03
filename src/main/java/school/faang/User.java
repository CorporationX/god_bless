package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public User(String name, int age, String workPlace, String adress) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortedUser = new HashMap<>();
        for (User user : users) {
            if (!sortedUser.containsKey(user.getAge())) {
                sortedUser.put(user.getAge(), new ArrayList<>());
            }
            sortedUser.get(user.getAge()).add(user);
        }
        return sortedUser;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAdress() {
        return adress;
    }

}