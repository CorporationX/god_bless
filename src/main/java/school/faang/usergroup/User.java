package school.faang.usergroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {
    String name;
    int age;
    String address;
    String workplace;

    public User(String name, int age, String address, String workplace) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.workplace = workplace;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }


    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        List<User> listByAge;
        int key;
        for (User user : usersList) {
            key = user.getAge();
            listByAge = new ArrayList<>();
            if (usersMap.containsKey(key)) {
                listByAge = usersMap.get(key);
            }
            listByAge.add(user);
            usersMap.put(key, listByAge);

        }
        return usersMap;
    }
}
