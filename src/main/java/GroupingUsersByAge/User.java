package GroupingUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    protected String name;
    protected String work;
    protected String home;
    protected int age;

    public String toString() {
        String text = "";
        text += this.name + " : name, ";
        text += this.work + " : work, ";
        text += this.home + " : home, ";
        text += this.age + " : age ";
        return text;
    }

    public User(String name, String work, String home, int age) {
        this.name = name;
        this.work = work;
        this.home = home;
        this.age = age;
    }

    // Map<Integer, List> usersMap = new HashMap<>();
    public static Map<Integer, List<User>> grouping(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.age;
            if (usersMap.containsKey(userAge)) {
                List<User> spisok = usersMap.get(userAge);
                spisok.add(user);
                usersMap.put(userAge, spisok);
            } else {
                List<User> newUser = new ArrayList<>();
                newUser.add(user);
                usersMap.put(userAge, newUser);
            }
        }
        return usersMap;
    }

    public static void main(String[] args) {

        User user1 = new User("Bob", "police", " Lenina", 36);
        User user2 = new User("Pit", "bilder", " Kirova", 36);
        User user3 = new User("Met", "trener", " Sverdlova", 23);
        User user4 = new User("Kail", "student", "Kurchatova", 23);
        User user5 = new User("Nail", "buhgalter", "Lenina", 56);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Map<Integer, List<User>> groupedUsers = grouping(users);
        System.out.println(groupedUsers);

    }
}

