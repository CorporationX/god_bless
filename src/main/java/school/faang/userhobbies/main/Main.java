package school.faang.userhobbies.main;

import school.faang.userhobbies.entity.User;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(1L, "Mike", 18, Set.of("Painting", "Hiking")),
                new User(2L, "Peter", 25, Set.of("Cooking", "Cycling", "Traveling")),
                new User(3L, "Lara", 25, Set.of("Photography", "Cycling", "Playing football"))
        );
        Set<String> allHobbies = Set.of(
                "Painting",
                "Hiking",
                "Cycling",
                "Cooking",
                "Traveling",
                "Playing football",
                "Photography"
        );
        System.out.println(User.findHobbyLovers(userList, allHobbies));
    }
}
