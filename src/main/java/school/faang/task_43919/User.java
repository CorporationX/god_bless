package school.faang.task_43919;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                '}';
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            List<User> usersList = new ArrayList<>();
            if (groupUsers.containsKey(user.getAge())) {
                usersList = groupUsers.get(user.getAge());
                usersList.add(user);
            } else {
                usersList.add(user);
                groupUsers.put(user.getAge(), usersList);
            }
        }
        return groupUsers;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        addUsersToList(users);
        groupUsers = groupUsers(users);
        System.out.println(groupUsers);
    }

    private static void addUsersToList(List<User> users) {
        users.add(new User("Oleg", 19, "Gas station", "Surgut, Lenin street"));
        users.add(new User("Aleksandr", 19, "Gas station", "Surgut, Lenin street"));
        users.add(new User("Andrew", 19, "Mvideo", "Surgut, Pushkin street"));
        users.add(new User("Svetlana", 23, "Theatre", "Surgut, Pushkin street"));
        users.add(new User("Mila", 18, "Theatre", "Surgut, Pushkin street"));
    }

}
