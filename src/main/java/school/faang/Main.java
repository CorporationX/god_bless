package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<User> usersList = new ArrayList<>();

    public static void main(String[] args) {
        User user = new User("Sergey", "21", "Uber", "Amsterdam");//correct name
        createValidUser("", "21", "Uber", "Amsterdam");//incorrect name
        createValidUser("Dmitry", "12", "Google", "London");//incorrect age
        createValidUser("Yakov", "20", "Amazon", "Moscow");//incorrect address
        createValidUser("Michail", "21", "Programmer", "New York");//incorrect job
        usersList.add(user);
        Map<String, List<User>> mapByAge = user.groupUsers(usersList);
        System.out.println("mapByAge = " + mapByAge.get("21"));
    }

    public static void createValidUser(String name, String age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            usersList.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
