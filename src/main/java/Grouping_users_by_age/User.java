package Grouping_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private String place_of_work;
    private String address;

    public Integer getAge() {
        return age;
    }

    public User (String name, Integer age, String place_of_work, String address) {
     this.name = name;
     this.age = age;
     this.place_of_work = place_of_work;
     this.address = address;
 }
    public static  Map <Integer, List<User>> groupUsers (List <User> users){
        Map <Integer, List <User>> map = new HashMap<>();
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
