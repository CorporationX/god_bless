package school.faang.bjs2_85788_1_1_2_1_age_grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {

        Map<Integer, List<User>> groupedUsers = new HashMap<Integer, List<User>>();

        for (User user : userList) {
            if (!groupedUsers.containsKey(user.getAge())) {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                groupedUsers.put(user.getAge(), newList);
            } else {
                groupedUsers.get(user.getAge()).add(user);
            }
        }

        return groupedUsers;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

