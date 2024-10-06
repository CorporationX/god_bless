package school.faang.group_by_age;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public String getString() {
        return name + ", " + age + ", " + placeWork + ", " + address;
    }

    static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMapByAge = new HashMap<>();

        for (User user : usersList) {
            List<User> valueAdded = usersMapByAge.computeIfAbsent(user.age, x -> new ArrayList<User>());
            valueAdded.add(user);
        }
        return usersMapByAge;
//        for (Map.Entry<Integer, List<User>> entry : usersMapByAge.entrySet()) {
//            List<User> selectedUsersList = entry.getValue();
//            System.out.println("Age " + entry.getKey());
//            for (User user : selectedUsersList) {
//                System.out.println("    - " + user.getString());
//            }
    }
}