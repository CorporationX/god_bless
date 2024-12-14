package faang.school.godbless.javacore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User{
    String name;
    int age;
    String workPlace;
    String address;

    public User(String name, int age, String workPlace, String address){
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
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

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users){
            int age = user.getAge();
            if (!map.containsKey(age)){
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(user);
        }
        return map;
    }

}
