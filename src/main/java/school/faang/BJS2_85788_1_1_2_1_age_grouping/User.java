package school.faang.BJS2_85788_1_1_2_1_age_grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private Integer age;
    private String workspace;
    private String address;

    public User(String name, Integer age, String workspace, String address) {
        this.name = name;
        this.age = age;
        this.workspace = workspace;
        this.address = address;
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> userList) {

        HashMap<Integer, List<User>> groupedUsers = new HashMap<Integer, List<User>>();

        for (User user: userList) {
            if (!groupedUsers.containsKey(user.age)) {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                groupedUsers.put(user.age, newList);
            } else {
                groupedUsers.get(user.age).add(user);
            }
        }

        return groupedUsers;
    }

    @Override
    public String toString(){
        return this.name;
    }

}

