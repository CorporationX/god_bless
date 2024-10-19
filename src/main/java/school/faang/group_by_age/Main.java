package school.faang.group_by_age;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> usersList = new ArrayList<User>();

        usersList.add(new User("Anton", 18, "Metro", "RU"));
        usersList.add(new User("Anna", 18, "X", "NY"));
        usersList.add(new User("Alex", 20, "MS", "SF"));
        usersList.add(new User("Sasha", 18, "Google", "JP"));
        usersList.add(new User("Tonya", 21, "Metro", "CH"));
        usersList.add(new User("Alla", 21, "VK", "RU"));
        usersList.add(new User("Zhenia", 20, "Apple", "US"));

        Map<Integer, List<User>> mapResult =  User.groupUsers(usersList);

    }
}