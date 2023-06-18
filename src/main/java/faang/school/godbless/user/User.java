package faang.school.godbless.user;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                "}";
    }

    public static Map<Integer, List<User>> group(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user: userList) {
            groupedUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void printGrouped(Map<Integer, List<User>> groupedList) {
        for (Map.Entry<Integer, List<User>> listEntry: groupedList.entrySet()) {
            System.out.println("Users with age " + listEntry.getKey());
            for (User user: listEntry.getValue()) {
                System.out.println(user);
            }
        }
    }
}
