package school.faang.groupingusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    /**
     * Группирует список пользователей по возрасту.
     * <p>
     * Метод принимает список пользователей и возвращает карту, где ключом является возраст,
     * а значением — список пользователей этого возраста.
     * </p>
     * <p>
     * Если входной список равен {@code null} или пуст, метод возвращает пустую карту.
     * </p>
     */
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null || users.isEmpty()) {
            return new HashMap<>();
        }

        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                groupedUsers.get(age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupedUsers.put(age, userList);
            }
        }
        return groupedUsers;
    }
}