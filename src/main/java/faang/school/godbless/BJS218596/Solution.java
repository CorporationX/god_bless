package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Dmitriy", 26, "Aston", "street 1"));
        users.add(new User("Ivan", 26, "Sber", "street 2"));
        users.add(new User("Oleg", 18, "Tinkoff", "street 3"));
        users.add(new User("Pavel", 19, "Yandex", "street 4"));

        Map<Integer, ArrayList<User>> groupUsersAge = User.groupUsers(users);
        for (Integer key : groupUsersAge.keySet()) {
            List<User> value = groupUsersAge.get(key);
            System.out.println(key + "-->" + value);
        }
    }
}
