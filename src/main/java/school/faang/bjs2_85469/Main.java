package school.faang.bjs2_85469;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> samHobbies = Set.of("football", "climbing", "parkour");
        Set<String> andrewHobbies = Set.of("fencing", "programming", "chess");
        Set<String> cyntiaHobbies = Set.of("painting", "cooking", "running");
        Set<String> harryHobbies = Set.of("swimming", "boxing", "piloting");
        Set<String> patriciaHobbies = Set.of("makeup", "shopping", "karate");

        User firstUser = new User("Sam", 31, samHobbies);
        User secondUser = new User("Andrew", 24, andrewHobbies);
        User thirdUser = new User("Cyntia", 18, cyntiaHobbies);
        User fourthUser = new User("Harry", 34, harryHobbies);
        User fifthUser = new User("Patricia", 21, patriciaHobbies);

        List<User> users = List.of(firstUser, secondUser, thirdUser, fourthUser, fifthUser);
        Set<String> certainHobbies = Set.of("painting", "football", "chess");

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, certainHobbies);
        hobbyLovers.forEach((user, certainHobby) -> System.out.println("User: " + user +
                " || Found hobby: " + certainHobby));
    }
}
