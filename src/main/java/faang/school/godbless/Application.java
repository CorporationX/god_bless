package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<User> users = List.of(
        new User("Ivan", 48, "Google", "682085, Moscow, ul.Novaja, 4-55"),
        new User("Sidor", 48, "Facebook", "682085, Moscow, ul.Novaja, 58-179"),
        new User("Petr", 64, "Amazon", "300205, Samara, ul.Staraja, 6-99"),
        new User("Anna", 42, "Microsoft", "890225, Voronez, ul.Novaja, 1-77"),
        new User("Vera", 31, "EPAM", "682085, Kursk, ul.Gagarina, 4-147"),
        new User("Ira", 20, "PandaDok", "245883, Bransk, ul.Sverdlova, 66-527"));

        Map<Integer, List<User>> mapGroup = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : mapGroup.entrySet()) {
            System.out.println("age " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        Set<String> ivanActivities = new HashSet<>(Arrays.asList("reading", "swimming", "cycling"));
        Set<String> petrActivities = new HashSet<>(Arrays.asList("running", "swimming", "cooking"));
        Set<String> fedrActivities = new HashSet<>(Arrays.asList("gaming", "cycling", "hiking"));

        User ivan = new User(1, "Ivan", 36, ivanActivities);
        User petr = new User(2, "Petr", 25, petrActivities);
        User fedr = new User(3, "Fedr", 16, fedrActivities);

        List<User> users = new ArrayList<>(Arrays.asList(ivan, petr, fedr));
        Set<String> hobbyActivities = new HashSet<>(Arrays.asList("reading", "cycling"));
        Map<User, String> findResult = User.findHobbyLovers(users, hobbyActivities);

        for (Map.Entry<User, String> entry : findResult.entrySet()) {
            System.out.println(entry.getKey() + ", " + "his activities - " + entry.getValue());
        }
    }
}
