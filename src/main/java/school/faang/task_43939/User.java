package school.faang.task_43939;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;


    public User() {
        this.name = Name.getRandomName();
        this.age = Utilities.getRandomIntegerWithinRange(20, 22);
        this.job = Job.getRandomJob();
        this.address = Address.getRandomAddress();
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> sortedByAgeMap = new HashMap<>();

        for (User user : users) {

            List<User> tempListWithSameAgeUsers = new ArrayList<>();

            int age = user.getAge();

            if (isAgeAlreadyInMapAsKey(age, sortedByAgeMap)) {
                tempListWithSameAgeUsers = sortedByAgeMap.get(age);
                tempListWithSameAgeUsers.add(user);
                sortedByAgeMap.put(age, tempListWithSameAgeUsers);
            } else {
                tempListWithSameAgeUsers.add(user);
                sortedByAgeMap.put(age, tempListWithSameAgeUsers);
            }
        }
        return sortedByAgeMap;
    }

    private static boolean isAgeAlreadyInMapAsKey(int age, Map<Integer, List<User>> map) {
        return map.containsKey(age);
    }
}
