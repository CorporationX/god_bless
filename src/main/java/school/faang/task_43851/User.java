package school.faang.task_43851;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    String name;
    int age;
    String workplace;
    String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> userList) {

        HashMap<Integer, List<User>> hashUsers = new HashMap<>();

        for (User u : userList) {

            if (!hashUsers.containsKey(u.age)) {
                hashUsers.put(u.age, new ArrayList<>(List.of(u)));
            } else {
                List<User> listValueHashUsers = hashUsers.get(u.age);
                listValueHashUsers.add(u);
                hashUsers.put(u.age, listValueHashUsers);
            }
        }
        return hashUsers;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name
                + '\''
                + ", age="
                + age
                + ", workplace='" + workplace
                + '\''
                + ", address='"
                + address
                + '\''
                + '}';
    }
}
