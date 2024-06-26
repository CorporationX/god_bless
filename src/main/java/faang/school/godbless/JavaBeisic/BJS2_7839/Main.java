package faang.school.godbless.JavaBeisic.BJS2_7839;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        try {
            userList.add(new User("Lexa", 18, "Google", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            userList.add(new User("Dima", 19, "Uber", "New York"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            userList.add(new User("Vika", 23, "Amazon", "Amsterdam"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            userList.add(new User("Semen", 23, "Yandex", "Moscow"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        Map<Integer, List<User>> groupedUsers = groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            if (!groupedUsers.containsKey(age)) {
                groupedUsers.putIfAbsent(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }


}
