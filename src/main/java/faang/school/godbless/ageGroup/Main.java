package faang.school.godbless.ageGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 27, "Analyst", "Broadway"));
        users.add(new User("Anna", 25, "Developer", "Maple Avenue"));
        users.add(new User("John", 30, "Designer", "Oak Street"));
        users.add(new User("Maria", 22, "Tester", "Pine Lane"));
        users.add(new User("David", 28, "Manager", "Cedar Road"));

        var result = groupUsers(users);
        result.entrySet().forEach(System.out::println);

        System.out.println();

        var resultWithGroupingBy = groupUsersWithGroupingBy(users);
        resultWithGroupingBy.entrySet().forEach(System.out::println);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();
        users.forEach(user -> usersGroupByAge.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user));
        return usersGroupByAge;
    }

    // Идея подсказывает вариант еще короче
    public static Map<Integer, List<User>> groupUsersWithGroupingBy(List<User> users) {
        return users.stream().collect(groupingBy(User::getAge));
    }
}
