package school.faang.user_hobby_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static school.faang.user_hobby_collection.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        Set<String> cheburaskaHobbies = new HashSet<>();
        cheburaskaHobbies.add("Running");
        cheburaskaHobbies.add("Swimming");
        cheburaskaHobbies.add("Play the garmoshka");
        cheburaskaHobbies.add("Crocodile hunting");

        Set<String> garfieldHobbies = new HashSet<>();
        garfieldHobbies.add("Eating");
        garfieldHobbies.add("Watching the TV");

        User cheburaska = new User(1, "Cheburashka", 57, cheburaskaHobbies);
        User garfield = new User(2, "Garfield", 46, garfieldHobbies);

        Set<String> hobbies = new HashSet<>();
        hobbies.add("Cooking");
        hobbies.add("Play the garmoshka");
        hobbies.add("Eating");
        hobbies.add("Crocodile hunting");

        List<User> users = new ArrayList<>();
        users.add(cheburaska);
        users.add(garfield);

        findHobbyLovers(users, hobbies);
    }
}
