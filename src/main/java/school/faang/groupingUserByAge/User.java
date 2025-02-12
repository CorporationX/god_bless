package school.faang.groupingUserByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            groupUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupUsers.get(user.getAge()).add(user);
        }

        return groupUsers;
    }

    @Override
    public String toString() {
        return new StringBuilder("User{")
                .append("name='").append(name).append('\'')
                .append(", age=").append(age)
                .append(", workplace='").append(workplace).append('\'')
                .append(", address='").append(address).append('\'')
                .append('}')
                .toString();
    }
}
