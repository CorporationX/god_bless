package school.faang.user_hobby_collection;

import java.util.Arrays;
import java.util.List;

import static school.faang.user_hobby_collection.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        List<String> cheburaskaHobbies = Arrays.asList(
                "Running",
                "Swimming",
                "Play the garmoshka",
                "Crocodile hunting"
        );
        List<String> garfieldHobbies = Arrays.asList(
                "Eating",
                "Watching the TV"
        );
        User cheburaska = new User(1, "Cheburashka", 57, cheburaskaHobbies);
        User garfield = new User(2, "Garfield", 46, garfieldHobbies);

        List<String> hobbies = Arrays.asList(
                "Cooking",
                "Play the garmoshka",
                "Eating",
                "Crocodile hunting"
        );
        List<User> users = Arrays.asList(
                cheburaska,
                garfield
        );
        findHobbyLovers(users, hobbies);
    }
}
