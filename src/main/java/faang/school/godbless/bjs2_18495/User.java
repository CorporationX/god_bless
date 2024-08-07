package faang.school.godbless.bjs2_18495;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String jobPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsersByAgeCheckValue(List<User> users) {
        var result = new HashMap<Integer, List<User>>();
        for (User user : users) {
            var age = user.getAge();
            var usersByAge = result.get(age);
            if (usersByAge == null) {
                usersByAge = new ArrayList<>();
                result.put(age, usersByAge);
            }
            usersByAge.add(user);
        }
        return result;
    }

    public static Map<Integer, List<User>> groupUsersByAgeCheckKey(List<User> users) {
        var result = new HashMap<Integer, List<User>>();
        for (User user : users) {
            var age = user.getAge();
            if (!result.containsKey(age)) {
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(user);
        }
        return result;
    }

    public static Map<Integer, List<User>> groupUsersByAgeJava8ForEach(List<User> users) {
        var result = new HashMap<Integer, List<User>>();
        users.forEach(user -> {
            result.computeIfAbsent(user.getAge(), usersByAge -> new ArrayList<>()).add(user);
        });
        return result;
    }

    public static Map<Integer, List<User>> groupUsersByAgeJava8GroupingBy(List<User> users) {
        var result = users.stream()
                .filter(u -> u.getAge() != null)
                .collect(groupingBy(User::getAge));
        result.put(null, users.stream().filter(u -> u.getAge() == null).toList());
        return result;
    }

    public static Map<Integer, List<User>> groupUsersByAgeJava8ToMap(List<User> users) {
        return users.stream()
                .collect(toMap(
                        User::getAge,
                        user -> new ArrayList<>(singletonList(user)),
                        (existingList, newList) -> {
                            existingList.addAll(newList);
                            return existingList;
                        }
                ));
    }

    public static void printUsersGroupedByAge(Map<Integer, List<User>> groupedUsersByAge) {
        groupedUsersByAge.forEach((key, value) -> {
            System.out.println("Age: " + key);
            System.out.println("    " + value);
        });
    }
}
