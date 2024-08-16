package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        addUser(users, "Dmitriy", 26, "Google", "London");
        addUser(users, "Ivan", 26, "Amazon", "Amsterdam");
        addUser(users, "Oleg", 18, "Google", "New York");
        addUser(users, "Pavel", 19, "Uber", "New York");

        Map<Integer, ArrayList<User>> groupUsersAge = User.groupUsers(users);
        for (Integer key : groupUsersAge.keySet()) {
            ArrayList<User> value = groupUsersAge.get(key);
            System.out.println(key + " --> " + value);
        }
    }

    private static void addUser(ArrayList<User> users, String name, Integer age, String placeWork, String address) {
        try {
            User user = new User(name, age, placeWork, address);
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении пользователя '" + name + "': " + e.getMessage());
        }
    }
}

