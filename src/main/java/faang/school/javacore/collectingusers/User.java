package faang.school.javacore.collectingusers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@AllArgsConstructor
@ToString
public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> activities;


    static private HashMap<User, String> findHobbyLovers(List<User> userList, Set<String> setActivities) {
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

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Set<String> setActivities = new HashSet<>();
        Set<String> activitiesAlex = new HashSet<>();
        Set<String> activitiesOleg = new HashSet<>();
        Set<String> activitiesMax = new HashSet<>();

        setActivities.add("Sport");
        setActivities.add("Box");

        activitiesAlex.add("Box");
        activitiesAlex.add("Programing");
        activitiesAlex.add("Sports hall");
        activitiesOleg.add("Programing");
        activitiesOleg.add("Sports hall");
        activitiesOleg.add("Sport");
        activitiesMax.add("running");
        activitiesMax.add("Reading books");

        User alex = new User(1, "Alex", 22, activitiesAlex);
        User oleg = new User(2, "oleg", 22, activitiesOleg);
        User max = new User(3, "Alex", 22, activitiesMax);

        userList.add(alex);
        userList.add(oleg);
        userList.add(max);

        HashMap<User, String> mapUser = findHobbyLovers(userList, setActivities);

        for (Map.Entry<User, String> user : mapUser.entrySet()) {
            System.out.println(user);
        }
    }
}
