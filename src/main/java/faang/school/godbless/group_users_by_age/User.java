package faang.school.godbless.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
//@ToString
public class User {
    private String userName;
    private int userAge;
    private String companyName;
    private String userAddress;

    protected static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();//список сгруппированных пользователей
        Set<Integer> userAges = new HashSet<>();//список возрастов пользователей

        //создание набора возрастов пользователей
        for (User user : users) {
            int age = user.getUserAge();
            userAges.add(age);
        }
        for (Integer userAge : userAges) {
            List<User> userList = new ArrayList<>();//список пользователей данного возраста
            for (User user : users) {
                if (user.getUserAge() == userAge) {
                    userList.add(user);
                }
                groupedUsers.put(userAge, userList);//добавляем список пользователей данного возраста в результирующий список
            }
        }
        return groupedUsers;
    }
}
