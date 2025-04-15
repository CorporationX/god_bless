package school.faang.BJS2_68058;


import java.util.*;

import static school.faang.BJS2_68058.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {


        Set<String> firstHobbies = new HashSet<>(Arrays.asList("Swimming", "Reading"));
        Set<String> secondHobbies = new HashSet<>(Arrays.asList("Jogging", "Swimming"));
        Set<String> thirdHobbies = new HashSet<>(Arrays.asList("Gaming", "Skiing"));
        Set<String> fourthHobbies = new HashSet<>(Arrays.asList("Reading", "Boxing"));

        User firstUser = new User(1, "Yerasyl", 25, firstHobbies);
        User secondUser = new User(2, "Vladimir", 30, secondHobbies);
        User thirdUser = new User(3, "Nikolay", 36, thirdHobbies);
        User fourthUser = new User(3, "Mger", 21, fourthHobbies);

        List<User> users = Arrays.asList(firstUser, secondUser, thirdUser, fourthUser);
        Set<String> hobbies = new HashSet<>(Arrays.asList("Gaming", "Swimming", "Dancing", "Painting"));
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
