package school.faang.JavaBasic.BJS2_31495;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Gaming", "Hiking"))),
                new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Cooking", "Swimming", "Traveling"))),
                new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("Gaming", "Reading", "Swimming"))),
                new User(4, "Diana", 28, new HashSet<>(Arrays.asList("Traveling", "Hiking", "Cooking"))),
                new User(5, "Edward", 35, new HashSet<>(Arrays.asList("Painting", "Cycling", "Reading"))),
                new User(6, "Fiona", 26, new HashSet<>(Arrays.asList("Gaming", "Traveling", "Hiking"))),
                new User(7, "George", 29, new HashSet<>(Arrays.asList("Swimming", "Cooking", "Reading"))),
                new User(8, "Hannah", 27, new HashSet<>(Arrays.asList("Cycling", "Traveling", "Painting"))),
                new User(9, "Ian", 24, new HashSet<>(Arrays.asList("Gaming", "Hiking", "Swimming"))),
                new User(10, "Julia", 32, new HashSet<>(Arrays.asList("Cooking", "Traveling", "Painting"))),
                new User(11, "Kevin", 23, new HashSet<>(Arrays.asList("Reading", "Cycling", "Hiking"))),
                new User(12, "Laura", 31, new HashSet<>(Arrays.asList("Swimming", "Traveling", "Gaming"))),
                new User(13, "Mike", 29, new HashSet<>(Arrays.asList("Cooking", "Reading", "Cycling"))),
                new User(14, "Nina", 28, new HashSet<>(Arrays.asList("Hiking", "Painting", "Traveling"))),
                new User(15, "Oscar", 34, new HashSet<>(Arrays.asList("Gaming", "Cooking", "Swimming")))
        ));
        Set<String> activities = new HashSet<>(Arrays.asList("Reading", "Gaming", "Cooking"));

        Map<User, String> groupingOfUsersByActivities = User.findHobbyLovers(users, activities);

        for(Map.Entry<User, String> entry : groupingOfUsersByActivities.entrySet()){
            System.out.println("Пользователь: " + entry.getKey() + " Активность: " + entry.getValue());
        }
    }
}
