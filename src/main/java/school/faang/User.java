package school.faang;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
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


    public static Map<Integer, List<User>> groupByUser(List<User> users) {
        Map<Integer, List<User>> userList = new HashMap<>();
        for (User user : users) {
            Integer age = user.getAge();
            if (!userList.containsKey(age)) {
                userList.put(age, new ArrayList<>());
            }
            userList.get(age).add(user);
        }
        return userList;
    }

    public static void main(String[] args) {
        User gangster = new User("John", 32, "street", "Times Square");
        User singer = new User("Richard", 23, "studio", "Grand Canyon");
        User dancer = new User("Alex", 56, "dance_studio", "Sequoia National Park");
        User hardWorker = new User("Michael", 44, "office", "Washington Monument");
        ArrayList<User> users = new ArrayList<>();
        users.add(gangster);
        users.add(singer);
        users.add(dancer);
        users.add(hardWorker);

        Map<Integer, List<User>> groupedList = groupByUser(users);

        groupedList.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
