package faang.school.godbless.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static HashMap<User, String> findHobbyLovers(ArrayList<User> users, ArrayList<String> hobbies) {
        HashMap<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            ArrayList<String> userActivities = user.getActivities();
            for (String activity: userActivities) {
                if (hobbies.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public static void showMap(HashMap<User, String> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        ArrayList<String> user1Hobbies = new ArrayList<>();
        user1Hobbies.add("football");
        user1Hobbies.add("TV");
        user1Hobbies.add("running");

        ArrayList<String> user2Hobbies = new ArrayList<>();
        user2Hobbies.add("baseball");
        user2Hobbies.add("TV");
        user2Hobbies.add("fashion");

        ArrayList<String> user3Hobbies = new ArrayList<>();
        user3Hobbies.add("dancing");
        user3Hobbies.add("TV");
        user3Hobbies.add("swimming");

        ArrayList<String> hobbies = new ArrayList<>();
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