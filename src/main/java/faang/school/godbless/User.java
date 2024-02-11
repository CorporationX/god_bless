package faang.school.godbless;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.work = workplace;
        this.address = address;
    }
    /*
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getWork() {
        return work;
    }
    public String getAddress() {
        return address;
    }
    */
    public static Map<Integer, List<User>> groupUser(List<User> usersList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : usersList) {
            if (!(groupedUsers.containsKey(user.age))) {
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }

    public static void main(String[] args){
        User john = new User("John", 37, "Uber", "City number one");
        User mike = new User("Mike", 32, "Nvidia", "City number two");
        User albert = new User("Albert", 29, "Google", "City number three");
        User frank = new User("Frank", 31, "Amazon", "City number four");

        List<User> users = new ArrayList<>();
        users.add(john);
        users.add(mike);
        users.add(albert);
        users.add(frank);

        System.out.println(User.groupUser(users));
    }
}