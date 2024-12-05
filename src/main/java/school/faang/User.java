package school.faang;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {
    private String name;
    private  int age;
    private String workspace;
    private String address;

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> map = new TreeMap<>();
//        for(User user: users) {
//            if(map.get(user.age) == null) {
//                map.put(user.age, user);
//                map.merge(user.age);
//            }
//        }
        return  map;

    }

}
