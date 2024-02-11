package faang.school.godbless;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@EqualsAndHashCode
@Setter
@Getter
public class User {
    private static int idNum = 0;
    private int id;
    private String name, placeOfWork, address;
    private int age;
    private Set<String> activity;

    User(String name, int age, Set<String> activity) {
        setId(idNum++);
        setActivity(activity);
        setAge(age);
        setName(name);
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activity) {
        Map<User, String> userActivity = new HashMap<>();

        for (User usFor : users) {
            for (String activUsFor : usFor.activity) {
                    if (activity.contains(activUsFor)) {
                        userActivity.put(usFor, activUsFor);
                        break;
                    }
                }
            }
        return userActivity;
    }
    User(String name, String placeOfWork, String address, int age) {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.age = age;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {//Вносим возраст и списки пользователй

            if (groupUsers.containsKey(user.age)) {
                List<User> ageAppropriateUser = groupUsers.get(user.age);
                ageAppropriateUser.add(user);
                groupUsers.put(user.age, ageAppropriateUser);
            }
            else {
                List<User> ageAppropriateUser = new ArrayList<>();
                ageAppropriateUser.add(user);
                groupUsers.put(user.age, ageAppropriateUser);
            }
        }
        return groupUsers;
    }
}

