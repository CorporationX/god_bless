package faang.school.javacore.collectingusers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    private static HashMap<User, String> findHobbyLovers(List<User> userList, Set<String> setActivities) {
        if (userList != null && setActivities != null) {
            HashMap<User, String> mapMatchingHobbies = new HashMap<>();
            for (User user : userList) {
                for (String userActivity : user.getActivities()) {
                    if (setActivities.contains(userActivity)) {
                        mapMatchingHobbies.put(user, userActivity);
                        break;
                    }
                }
            }
            return mapMatchingHobbies;
        }
        return null;
    }

    public static void main(String[] args) {
        Set<String> setActivities = new HashSet<>(Arrays.asList("Sport", "Box"));
        Set<String> activitiesAlex = new HashSet<>(Arrays.asList("Box", "Programing", "Sports hall"));
        Set<String> activitiesOleg = new HashSet<>(Arrays.asList("Programing", "Sports hall", "Sport"));
        Set<String> activitiesMax = new HashSet<>(Arrays.asList("Running", "Reading books"));

        User alex = new User(1, "Alex", 22, activitiesAlex);
        User oleg = new User(2, "oleg", 22, activitiesOleg);
        User max = new User(3, "Alex", 22, activitiesMax);

        List<User> userList = new ArrayList<>(Arrays.asList(alex, oleg, max));

        printMatchingHobbies(findHobbyLovers(userList, setActivities));
    }

    private static void printMatchingHobbies(HashMap<User, String> mapHobbyUsers) {
        if (mapHobbyUsers != null) {
            for (Map.Entry<User, String> userLoverHobby : mapHobbyUsers.entrySet()) {
                System.out.println(userLoverHobby);
            }
        }
    }
}
