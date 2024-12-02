package school.faang;

import java.util.*;

public class User {
    private final String name;
    private final Integer age;
    private final String workplace;
    private final String address;

    public User(String name, Integer age, String workplace, String address){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User u : users){
            groupedUsers.computeIfAbsent(u.getAge(), (Key) -> new ArrayList<>()).add(u);
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
