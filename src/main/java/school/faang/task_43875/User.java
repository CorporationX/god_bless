package school.faang.task_43875;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public User(String name, Integer age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", workplace='" + workplace + '\''
                + ", address='" + address + '\''
                + '}';
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User currentUser : users) {
            List<User> currentUserList = groupedUsers.get(currentUser.age);
            if (currentUserList != null) {
                currentUserList.add(currentUser);
                groupedUsers.put(currentUser.age, currentUserList);
            } else {
                List<User> newList = new ArrayList<>();
                newList.add(currentUser);
                groupedUsers.put(currentUser.age, newList);
            }
        }
        return groupedUsers;
    }
}


