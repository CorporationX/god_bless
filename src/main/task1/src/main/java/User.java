import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String addressOfJob;
    private String address;

    public User() {

    }

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUsers){
        Map<Integer, List<User>> map = new HashMap<>();

        for(User user : listUsers){
            if(!map.containsKey(user.getAge())){
                List<User> newListAdd= new ArrayList<>();
                newListAdd.add(user);
                map.put(user.getAge(), newListAdd);
            } else {
                List<User> listUserForAge = map.get(user.getAge());
                listUserForAge.add(user);
                map.put(user.getAge(), listUserForAge);
            }
        }
        return map;
    }
}
