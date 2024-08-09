package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Dmitriy", 26, "Aston", "street 1"));
        users.add(new User("Ivan", 26, "Sber", "street 2"));
        users.add(new User("Oleg", 18, "Tinkoff", "street 3"));
        users.add(new User("Pavel", 19, "Yandex", "street 4"));

        HashMap<Integer, ArrayList<User>> groupUsersAge = User.groupUsers(users);
        for (Integer key : groupUsersAge.keySet()) {
            ArrayList<User> value = groupUsersAge.get(key);
            System.out.println(key + "-->" + value);
        }
    }
}
