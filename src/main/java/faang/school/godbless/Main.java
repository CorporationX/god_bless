package faang.school.godbless;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> firstActivitiesSet = new HashSet<>();
        firstActivitiesSet = Set.of("english", "art", "math");

        Set<String> secondActivitiesSet = new HashSet<>();
        secondActivitiesSet = Set.of("english","art", "math");

        Set<String> thirdActivitiesSet = new HashSet<>();
        thirdActivitiesSet = Set.of("math","literature", "geography");

        Set<String> targetSet = new HashSet<>();
        targetSet = Set.of("informatics", "geography", "art");

        List<Set> activitiesSet = new ArrayList<>();
        activitiesSet = List.of(firstActivitiesSet, secondActivitiesSet, thirdActivitiesSet);

        User firstUser = new User("Max", firstActivitiesSet, 1, 23);
        User secondUser = new User("Elena", secondActivitiesSet, 2, 23);
        User thirdUser = new User("Jeny", thirdActivitiesSet, 3, 30);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(firstUser);
        userList.add(secondUser);
        userList.add(thirdUser);

        for(Map.Entry<User, String> entry : User.findHobbyLovers(userList, targetSet).entrySet()) {
            System.out.println("Для пользователя: " + entry.getKey().name + ", выбрана активность: " + entry.getValue());
        }
    }
}