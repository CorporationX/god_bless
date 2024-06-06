package faang.school.godbless;

import java.util.*;
import java.util.Map;
import java.util.List;

public class User extends Application{

    protected String name;
    protected int age;
    protected String workplace;
    protected String adress;

    public User(String name, int age, String workplace, String adress){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
    }

    public static Map<Integer , List<User>> groupUsers(List<User> user){
        Map<Integer , List<User>> map = new HashMap<>();
        for(User users : user){
            if(map.containsKey(users.age)){
                map.get(users.age).add(users);
            } else {
                List<User> Userlist = new ArrayList<>();
                Userlist.add(users);
                map.put(users.age , Userlist);
            }
        }
        return map;
    }
}