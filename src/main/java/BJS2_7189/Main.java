package BJS2_7189;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User vitalia = new User(1, "Vitalij",35, Set.of("basketball", "football"));
        User veronik = new User(2, "Veronika",33, Set.of("basketball", "football"));
        User leonid = new User(2, "Leonid",33, Set.of("hockey", "tennis"));

        Set<String> hobbies = Set.of("basketball", "football");

        List<User> users = List.of(vitalia, veronik,leonid);

        Map<User, String> userHobbies;
        userHobbies =  vitalia.findHobbyLovers(users, hobbies);
        System.out.println(userHobbies);
    }
}
