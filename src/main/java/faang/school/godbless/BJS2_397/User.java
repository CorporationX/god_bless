package faang.school.godbless.BJS2_397;

import lombok.Data;

import java.util.*;

@Data
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public User (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> userList) {

        Map<Integer, List<User>> groupUserMap = new HashMap<>();

        for (User x : userList) {

            int currentUserAge = x.getAge();

            List<User> userSet =
                    groupUserMap.getOrDefault(x.getAge(), new ArrayList<>());

            userSet.add(x);
            groupUserMap.put(currentUserAge, userSet);

        }

        return groupUserMap;
    }
}
