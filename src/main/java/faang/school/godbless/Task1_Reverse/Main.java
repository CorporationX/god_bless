package faang.school.godbless.Task1_Reverse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static faang.school.godbless.Task1_Reverse.User.findHobbyLovers;

public class Main {

    public static void showMap(HashMap<User, String> map) {
        System.out.println("The Map is below:");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Set<String> user1Hobbies = new HashSet<>();
        user1Hobbies.add("football");
        user1Hobbies.add("TV");
        user1Hobbies.add("running");

        Set<String> user2Hobbies = new HashSet<>();
        user2Hobbies.add("baseball");
        user2Hobbies.add("TV");
        user2Hobbies.add("fashion");

        Set<String> user3Hobbies = new HashSet<>();
        user3Hobbies.add("dancing");
        user3Hobbies.add("TV");
        user3Hobbies.add("swimming");

        Set<String> hobbies = new HashSet<>();
        hobbies.add("football");
        hobbies.add("TV");
        hobbies.add("dancing");

        User user1 = new User(1,"Andrew", 26, user1Hobbies);
        User user2 = new User(2,"Mike", 25, user2Hobbies);
        User user3 = new User(3,"John", 24, user3Hobbies);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        HashMap<User, String> commonHobbies = findHobbyLovers(users, hobbies);
        showMap(commonHobbies);

    }

}