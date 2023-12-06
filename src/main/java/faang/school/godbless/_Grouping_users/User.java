package faang.school.godbless._Grouping_users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class User {
    public String name;
    public  int age;
    public String  work_place;
    public String address;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", work_place='" + work_place + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Map<Integer,List<User>> groupUsers(List<User> users){

        Map<Integer,List<User>> mapUsers = new HashMap<>();
        for(User user :users){
            if( !mapUsers.containsKey(user.age)) {
                mapUsers.put(user.age, new ArrayList<>());
            }
            mapUsers.get(user.age).add(user);
        }
        return mapUsers;

    }
}
