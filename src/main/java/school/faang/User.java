package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name;
    int age;
    String placeWork;
    String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public String getString() {
        return name + ", " + age + ", " + placeWork + ", " + address;
    }

    static void groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMapByAge = new HashMap<>();

        for (User user : usersList) {
            usersMapByAge.computeIfAbsent(user.getAge(), x -> new ArrayList<User>());

            List<User> valueAdded = usersMapByAge.get(user.getAge());
            valueAdded.add(user);
        }

        for (Map.Entry<Integer, List<User>> entry : usersMapByAge.entrySet()) {
            List<User> selectedUsersList = entry.getValue();
            System.out.println("Age " + entry.getKey());
            for (User user : selectedUsersList) {
                System.out.println("    - " + user.getString());
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceWork() {
        return placeWork;
    }

    public String getAddress() {
        return address;
    }
}