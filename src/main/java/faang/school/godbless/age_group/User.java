package faang.school.godbless.age_group;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {

    String name;
    int age;
    String workplace;
    String address;

    private static Map<Integer, List<User>> userMap = new HashMap<>();

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users){


        for (User user : users){
            if (!userMap.containsKey(user.getAge())){
                List<User> list = new ArrayList<>();
                list.add(user);
                userMap.put(user.getAge(), list);
            } else {
                List<User> list = userMap.get(user.getAge());
                list.add(user);
                userMap.put(user.getAge(), list);
            }

        }
        return userMap;
    }

    public static void print(){
        for(Map.Entry<Integer, List<User>> entry : userMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static int getListSize(int key){
        return userMap.get(key).size();
    }
}
