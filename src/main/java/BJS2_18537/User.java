package BJS2_18537;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class User {
    String name;
    int age;
    String job;
    String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer,List<User>> resultMap = new HashMap<>();

        for(User user : users){
            if(!resultMap.containsKey(user.age)){
                resultMap.put(user.age, new ArrayList<>());
                resultMap.get(user.age).add(user);
            }
            else{
                resultMap.get(user.age).add(user);
            }
        }

        return resultMap;
    }
}
