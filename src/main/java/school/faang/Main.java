package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<User> usersList = new ArrayList<>();

    public static void main(String[] args) {
        User user = new User("", "21", "Uber", "Amsterdam");//incorrect name
        User user2 = new User("Dmitry", "12", "Google", "London");//incorrect age
        User user3 = new User("Yakov", "20", "Amazon", "Moscow");//incorrect address
        User user4 = new User("Michail", "21", "Programmer", "New York");//incorrect job
        usersList.add(user);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        Map<String, List<User>> mapByAge = user.groupUsers(usersList);
        System.out.println(mapByAge.get("21"));
    }

}
