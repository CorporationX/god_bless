package Grouping_by_age_BJS2_67955;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        //вносим пользователей в список
        users.add(new User("Alex", 20, "Theatre", "London"));
        users.add(new User("Sonya", 29, "Mosque", "Budapest"));
        users.add(new User("Margaret", 48, "Hospital", "Los Angeles"));
        users.add(new User("Fred", 20, "Shop", "Vienna"));

        Map<Integer, List<User>> groupedUsers = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("Имя: " + user.getName());
                System.out.println("Место работы: " + user.getWorkplace());
                System.out.println("Адрес: " + user.getAddress());
            }

        }


    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if(!userGroups.containsKey(age)){
                userGroups.put(age, new ArrayList<>());
            }
            userGroups.get(age).add(user);
        }
        return userGroups;
    }
}

