package faang.school.godbless.Task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {

    private String name;
    private int age;
    private String place;
    private String address;

    @Override
    public String toString() {
        return name;
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int key = user.getAge();
            List<User> sameAge = new ArrayList<>();
            for (User user1 : users) {
                if (user1.getAge() == key) {
                    sameAge.add(user1);
                }
            }
            userGroups.put(key, sameAge);
        }
        return (HashMap<Integer, List<User>>) userGroups;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Andrew", 26, "Moscow", "Street1"));
        users.add(new User("John", 25, "Moscow", "Street1"));
        users.add(new User("Jane", 25, "Moscow", "Street1"));
        users.add(new User("Jordan", 26, "Moscow", "Street1"));
        HashMap<Integer, List<User>> ageGroups = groupUsers(users);
        System.out.println(ageGroups);

    }

}