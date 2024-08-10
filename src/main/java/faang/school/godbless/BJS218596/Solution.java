package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Dmitriy", 26, "Google", "London"));
        users.add(new User("Ivan", 26, "Amazon", "Amsterdam"));
        users.add(new User("Oleg", 18, "Google", "New York"));
        users.add(new User("Pavel", 19, "Uber", "New York"));

        HashMap<Integer, ArrayList<User>> groupUsersAge = User.groupUsers(users);
        for (Integer key : groupUsersAge.keySet()) {
            ArrayList<User> value = groupUsersAge.get(key);
            System.out.println(key + "-->" + value);
        }
    }
}
