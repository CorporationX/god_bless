package sprint2.groupByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class User {

    private String name;
    private int age;
    private String locationOfWork;
    private String address;

    public User(String name, int age, String locationOfWork, String address) {
        this.name = name;
        this.age = age;
        this.locationOfWork = locationOfWork;
        this.address=address;
    }

    public static Map<Integer, List<String>> groupUsers(List<User> users) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (User user : users) {
            int tempAge = user.age;
            if (!(map.containsKey(tempAge))){
            map.put(tempAge,new ArrayList<>());
            map.get(tempAge).add(user.name);
            } else {
                map.get(tempAge).add(user.name);
            }
        }
        return map;
    }
}
