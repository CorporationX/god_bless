package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {

    private final String name;
    @Getter
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address){

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> result = users.stream().collect(Collectors.groupingBy(User::getAge));

//        Map<Integer, List<User>> result =new HashMap<>();
//        for (User user : users){
//            if (!result.containsKey(user.age)){
//                result.put(user.age, new ArrayList<>());
//            }
//            result.get(user.age).add(user);
//        }

        return result;
    }
}