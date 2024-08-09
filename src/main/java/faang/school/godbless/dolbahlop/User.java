package faang.school.godbless.dolbahlop;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    // Группировки пользователей по возрасту
    public static Map<Integer, List<User>> groupUsersByAge(List<User> users){
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();

        for (User user : users){
            addUserToAgeGroup(usersGroupedByAge, user);
        }

        return usersGroupedByAge;
    }

    // Добавляет пользователя в его возрастную группу
    private static void addUserToAgeGroup(Map<Integer, List<User>> usersGroupedByAge, User user){
        int age = user.age;
        List<User> usersWithinTheSameAgeGroup = getUsersWithinTheSameAgeGroup(usersGroupedByAge, age);
        usersWithinTheSameAgeGroup.add(user);
        usersGroupedByAge.put(age, usersWithinTheSameAgeGroup);
    }

    //Получает список пользователей с таким же возрастом
    private static List<User> getUsersWithinTheSameAgeGroup(Map<Integer, List<User>> usersGroupedByAge, int age) {
        return usersGroupedByAge.getOrDefault(age, new ArrayList<>());
    }
}
