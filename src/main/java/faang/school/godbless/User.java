package faang.school.godbless;

import java.util.*;

public class User {
    private int age;
    private String name, placeOfWork, address;

    User(String name, String placeOfWork, String address, int age) {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.age = age;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        Set<Integer> age = new HashSet<>();

        for (User user : users) {//Вносим возраст и списки пользователй
            List<User> ageAppropriateUser = new ArrayList<>();
            for (User userAge : users) {//Создаем список пользователей
                // соответствующий возрасту
                if (userAge.age == user.age) {
                    ageAppropriateUser.add(userAge);
                }
            }
            groupUsers.put(user.age, ageAppropriateUser);
        }
        return groupUsers;
    }
}