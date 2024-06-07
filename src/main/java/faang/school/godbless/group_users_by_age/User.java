package faang.school.godbless.group_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String userName,
                   int userAge,
                   String companyName,
                   String userAddress) {

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> users) {
        Map<Integer, ArrayList<User>> groupedUsers
                = new HashMap<>();//список сгруппированных пользователей
        for (User user : users) {
            int age = user.userAge();
            if (groupedUsers.containsKey(age)) {
                ArrayList<User> usersByAge = groupedUsers.get(age);
                usersByAge.add(user);
            } else {
                ArrayList<User> usersByAge = new ArrayList<>();
                usersByAge.add(user);
                groupedUsers.put(age, usersByAge);
            }
        }
        return groupedUsers;
    }
}
