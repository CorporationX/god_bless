import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public int getAge() {
        return age;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for(User user : users){
            if(!groupedUsers.containsKey(user.getAge())){
                List<User> addFirstUser= new ArrayList<>();
                addFirstUser.add(user);
                groupedUsers.put(user.getAge(), addFirstUser);
            } else {
                List<User> addOtherUsers = groupedUsers.get(user.getAge());
                addOtherUsers.add(user);
                groupedUsers.put(user.getAge(), addOtherUsers);
            }
        }
        return groupedUsers;
    }
}
