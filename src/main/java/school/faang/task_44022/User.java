package school.faang.task_44022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<Integer, ArrayList<User>>();
        Set<Integer> userAgeSet = new HashSet<Integer>();
        for (User user : users) {
            if (!(userAgeSet.contains(user.age))) {
                ArrayList<User> usersAgeGroup = new ArrayList<User>();
                usersAgeGroup.add(user);
                userAgeSet.add(user.age);
                userMap.put(user.age, usersAgeGroup);
            } else {
                ArrayList<User> usersAgeGroup = userMap.get(user.age);
                usersAgeGroup.add(user);
            }
        }
        return userMap;
    }

}
