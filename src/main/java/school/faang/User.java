package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address){

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public int getAge(){
        return this.age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> result =new HashMap<>();
        for (User user : users){
            if (result.containsKey(user.age)) continue;

            List<User> tmpUsers = new ArrayList<>();
            for (User user1 : users){
                if (user.age == user1.age){
                    tmpUsers.add(user1);
                }
            }
            result.put(user.age, tmpUsers);
        }
//        result = users.stream().collect(Collectors.groupingBy(User::getAge));

        return result;
    }
}