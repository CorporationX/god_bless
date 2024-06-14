package faang.school.godbless;

import java.util.*;
import java.util.Map;
import java.util.List;

public class User {

    private final String name;
    private final int age;
    private final String workplace;
    private final String adress;

    public User(String name, int age, String workplace, String adress){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
    }

    public static Map<Integer , List<User>> groupUsers(List<User> user){
        Map<Integer , List<User>> groupedUsers = new HashMap<>();
        for(User record : user){
            if(groupedUsers.containsKey(record.age)){
                groupedUsers.get(record.age).add(record);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(record);
                groupedUsers.put(record.age , userList);
            }
        }
        return groupedUsers;
    }
    public void getRecord(){
        System.out.println(name + " , " + workplace + " , " + adress);
    }
}