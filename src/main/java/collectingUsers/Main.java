package collectingUsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> activitiesOfUserA = new HashSet<String>(Set.of("сон", "поиск мемов", "что-то полезное"));
        Set<String> activitiesOfUserB = new HashSet<String>(Set.of("чтение", "что-то важное", "что-то бесполезное"));

        User anna = new User(1, "Anna", 12, activitiesOfUserA);
        User bato = new User(2, "Bato", 15, activitiesOfUserB);

        List<User> usersList = new ArrayList<User>();
        usersList.add(anna);
        usersList.add(bato);

        Set<String> activitiesSet = new HashSet<String>(Set.of("что-то бесполезное", "что-то полезное", "что-то важное", "cон"));

        System.out.println(User.findHobbyLovers(usersList, activitiesSet));

    }

}
