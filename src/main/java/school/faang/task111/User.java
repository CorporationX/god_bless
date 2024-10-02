package school.faang.task111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;

    private int age;

    private String workPlace;

    private String address;

    public int getAge() {
        return age;
    }

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> answer = new HashMap<>();
        for(User user : users){
           if(answer.get(user.getAge())!=null){
               answer.get(user.getAge()).add(user);
           }
           else {
               List<User> mapList = new ArrayList<>();
               mapList.add(user);
               answer.put(user.getAge(),mapList);
           }
        }
        return answer;
    }
}
