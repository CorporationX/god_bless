package school.faang.task_44027;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<User> users = new ArrayList<>();
        String[] possibleHobbies = {"Football", "Music", "Gaming", "Cooking", "Traveling", "Reading"};

        for (int i = 0; i <= 10; i++) {
            Set<String> hobbies = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                hobbies.add(possibleHobbies[faker.number().numberBetween(0, possibleHobbies.length)]);
            }

            User user = new User(
                    faker.name().fullName(),
                    faker.number().numberBetween(18, 50),
                    hobbies
            );
            users.add(user);
        }

        Set<String> targetHobbies = Set.of("Gaming", "Music", "Traveling");
        System.out.println("Target hobbies: " + targetHobbies);

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, targetHobbies);

        System.out.println("Users with matching hobbies:");
        hobbyLovers.forEach((user, hobby) -> {
            System.out.println(user.getName() + " (ID: " + user.getId() + ") loves: " + hobby);
        });
    }
}
