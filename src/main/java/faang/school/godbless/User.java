package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter

public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public static void main(String[] args) {
        User user = new User("roma",17,"aaa","aasdf");
        User user1 = new User("asdfas", 44,"asfasdf","asfd");

        List<User> arrayList= new ArrayList<>();
        arrayList.add(user1);
        arrayList.add(user);

        groupUsers(arrayList);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> map = new HashMap<>();
        for (User user : users) {
            int age = user.age;
            if(map.containsKey(age)){
                map.get(age).add(user);
            } else {
                List<User> newList= new ArrayList<>();
                newList.add(user);
                map.put(age,newList);
            }
        }
        return map;
    }


}
