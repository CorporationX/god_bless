package school.faang.task_44003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        //Create new Hashmap where the key is the age and the value is a  List of users
        Map<Integer, List<User>> userByAge = new HashMap<>();
        for (User usr : users) {
            //if no list users in the Map create a new one
            userByAge.putIfAbsent(usr.getAge(), new ArrayList<>());
            userByAge.get(usr.getAge()).add(usr);
        }
        return userByAge;
    }
}