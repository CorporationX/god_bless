package school.faang.group_user_by_age;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> resultList = new HashMap<>();

        for (User user : usersList) {
            if (resultList.containsKey(user.getAge())) {
                List<User> peers = resultList.get(user.getAge());
                peers.add(user);
                resultList.put(user.getAge(), peers);
            } else {
                List<User> peers = new ArrayList<>();
                peers.add(user);
                resultList.put(user.getAge(), peers);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Andrew", 31, "factory", "small street"));
        users.add(new User("Oliver", 34, "store", "big street"));
        users.add(new User("Ilya", 33, "Google", "middle street"));
        users.add(new User("Denis", 32, "delivery", "big street"));
        users.add(new User("Ruslan", 33, "Yandex", "small street"));
        users.add(new User("Nikita", 33, "Sber", "middle street"));
        users.add(new User("Alex", 34, "factory", "middle street"));
        users.add(new User("Karina", 31, "unemployed", "big street"));
        users.add(new User("Brian", 34, "police", "small street"));
        users.add(new User("Jinx", 31, "unemployed", "middle street"));
        users.add(new User("Catheline", 32, "guard", "small street"));
        users.add(new User("Vi", 32, "unemployed", "big street"));
        users.add(new User("Viktor", 30, "scientist", "middle street"));

        Map<Integer, List<User>> sortedUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : sortedUsers.entrySet()) {
            System.out.println("age = " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
