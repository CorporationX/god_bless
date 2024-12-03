package school.faang.task_43896;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> usersMap = new HashMap<>();

        for (User user : users) {
            if (!usersMap.containsKey(user.getAge())) {
                ArrayList<User> usersList = new ArrayList<>();
                usersMap.put(user.getAge(), usersList);
            }

            ArrayList<User> userArrayList = usersMap.get(user.getAge());
            userArrayList.add(user);
        }

        return usersMap;
    }
}
