package school.faang.BJS2_85469;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> samHobbies = new HashSet<>();
        Collections.addAll(samHobbies, "football", "climbing", "parkour");

        Set<String> andrewHobbies = new HashSet<>();
        Collections.addAll(andrewHobbies, "fencing", "programming", "chess");

        Set<String> cyntiaHobbies = new HashSet<>();
        Collections.addAll(cyntiaHobbies, "painting", "cooking", "running");

        Set<String> harryHobbies = new HashSet<>();
        Collections.addAll(harryHobbies, "swimming", "boxing", "piloting");

        Set<String> patriciaHobbies = new HashSet<>();
        Collections.addAll(patriciaHobbies, "makeup", "shopping", "karate");

        User firstUser = new User("Sam", 31, samHobbies);
        User secondUser = new User("Andrew", 24, andrewHobbies);
        User thirdUser = new User("Cyntia", 18, cyntiaHobbies);
        User fourthUser = new User("Harry", 34, harryHobbies);
        User fifthUser = new User("Patricia", 21, patriciaHobbies);

        List<User> users = new ArrayList<>();
        Collections.addAll(users, firstUser, secondUser, thirdUser, fourthUser, fifthUser);

        Set<String> certainHobbies = new HashSet<>();
        Collections.addAll(certainHobbies, "painting", "football", "chess");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, certainHobbies);
        hobbyLovers.forEach((user, certainHobby) -> System.out.println("User: " + user + " || Found hobby: " + certainHobby));
    }
}
