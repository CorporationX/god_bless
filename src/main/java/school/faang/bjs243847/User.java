package school.faang.bjs243847;

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
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", workPlace='" + workPlace + '\''
                + ", address='" + address + '\''
                + '}';
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroup = new HashMap<>();

        for (User user : users) {
            userGroup.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }
        return userGroup;
    }

    private static void printUsers(Map<Integer, List<User>> groupedUsers) {
        groupedUsers.forEach((integer, users) -> {
            System.out.println("Age = " + integer + " : " + "List student = " + users);
        });
    }

    public static void main(String[] args) {
        User user1 = new User("Oleg", 24, "Economist", "Moscow");
        User user2 = new User("Elena", 25, "Manager", "Kazan");
        User user3 = new User("Sergey", 20, "Administrator", "N.Novgorod");
        User user4 = new User("Svetlana", 24, "Economist", "Barnaul");
        User user5 = new User("Elizaveta", 24, "Manager", "Moscow");
        User user6 = new User("Pavel", 20, "Shop assistant", "Saint-Petersburg");
        User user7 = new User("Roman", 28, "Economist", "Ufa");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);

        Map<Integer, List<User>> usersGroupedAge = groupUsers(userList);

        System.out.println("After grouped users age:");
        printUsers(usersGroupedAge);
    }
}
