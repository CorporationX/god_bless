package school.faang.user_hobby_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static school.faang.user_hobby_collection.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        Set<String> cheburaskaHobbies = Set.of(
                "Running",
                "Swimming",
                "Play the garmoshka",
                "Crocodile hunting");

        Set<String> garfieldHobbies = Set.of(
                "Eating",
                "Watching the TV");

        User cheburaska = new User(1, "Cheburashka", 57, cheburaskaHobbies);
        User garfield = new User(2, "Garfield", 46, garfieldHobbies);

        Set<String> hobbies = Set.of(
                "Cooking",
                "Play the garmoshka",
                "Eating",
                "Crocodile hunting");

        List<User> users = new ArrayList<>();
        users.add(cheburaska);
        users.add(garfield);

        findHobbyLovers(users, hobbies);
    }
}
