package collectingUsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activitiesOfUserA = new HashSet<>();
        activitiesOfUserA.add("сон");
        activitiesOfUserA.add("поиск мемов");
        activitiesOfUserA.add("что-то полезное");

        Set<String> activitiesOfUserB = new HashSet<>();
        activitiesOfUserB.add("чтение");
        activitiesOfUserB.add("что-то важное");
        activitiesOfUserB.add("что-то бесполезное");

        User userA = new User(1, "Anna", 12, activitiesOfUserA);
        User userB = new User(2, "Bato", 15, activitiesOfUserB);

        List<User> usersList = new ArrayList<User>();
        usersList.add(userA);
        usersList.add(userB);

        Set<String> activitiesSet = new HashSet<String>();
        activitiesSet.add("что-то бесполезное");
        activitiesSet.add("что-то полезное");
        activitiesSet.add("что-то важное");
        activitiesSet.add("cон");

        System.out.println(User.findHobbyLovers(usersList, activitiesSet));

    }

}
