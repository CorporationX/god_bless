package school.faang.sprint_1.task_bjs2n43974;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workspace;
    private String address;

    public User(String name, int age, String workspace, String address) {
        this.name = name;
        this.age = age;
        this.workspace = workspace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new TreeMap<>();
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (map.get(user.age) == null) {
                userList.add(user);
                map.put(user.age, userList);
            } else {
                map.get(user.age).add(user);
            }
        }
        return map;

    }

    @Override
    public String toString() {
        return String.format("User{name= \"%s\", age=%d, workspace=\"%s\", address=\"%s\"",
                name,
                age,
                workspace,
                address
        );
    }
}
