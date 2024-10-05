package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static List<User> usersList = new ArrayList<>();

    public static void main(String[] args) {
        User user = new User("Sergey", "21", "Student", "Moscow");
        User user2 = new User("Dmitry", "21", "Programmer", "Moscow");
        User user3 = new User("Yakov", "20", "Student", "Moscow");
        User user4 = new User("Michail", "21", "Programmer", "Moscow");
        usersList.add(user);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        System.out.println("age of user = "+user.getAge()+"\n");
        Map<String, List<User>> mapByAge = user.groupUsers(usersList);
        System.out.println(mapByAge.get("21"));

    }

}
