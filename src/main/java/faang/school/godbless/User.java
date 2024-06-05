package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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

    public static Map<Integer, List<User>> convertListToMapOfGroupUsers(List<User> userList) {
        Map<Integer, List<User>> listUsersMap = new HashMap<>();

        for (User user : userList) {
            listUsersMap.put(user.getAge(), userList.stream().filter(user1 -> user1.getAge() == user.getAge()).toList());
        }

        return listUsersMap;
    }

    public static void main(String[] args) {
        User user1 = new User("test", 12, "test", "test");
        User user2 = new User("test2", 3, "test2", "test2");
        User user3 = new User("test3", 10, "test3", "test3");
        User user4 = new User("test4", 12, "test4", "test4");
        User user5 = new User("test5", 3, "test5", "test5");
        User user6 = new User("test6", 10, "test6", "test6");
        User user7 = new User("test7", 12, "test7", "test7");
        User user8 = new User("test8", 3, "test8", "test8");
        User user9 = new User("test9", 10, "test9", "test9");
        User user10 = new User("test10", 12, "test10", "test10");


        Map<Integer, List<User>> result = convertListToMapOfGroupUsers(List.of(user1, user2, user3, user4,
                user5, user6, user7, user8, user9, user10));

        result.forEach((key, value) -> System.out.println("Ключ: " + key + " - Значение:" + value));
    }
}
