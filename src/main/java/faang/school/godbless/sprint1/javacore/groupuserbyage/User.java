package faang.school.godbless.sprint1.javacore.groupuserbyage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageToUsers = new HashMap<>();
        for (User user : users) {
            ageToUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return ageToUsers;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", address=" + address +
                '}';
    }
}
