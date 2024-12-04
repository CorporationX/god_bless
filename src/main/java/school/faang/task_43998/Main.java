package school.faang.task_43998;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int usersCount = 10;
        int activitiesCount = 3;

        List<User> users = generateUsers(usersCount);
        Set<String> searchedActivities = generateActivities(activitiesCount);

        System.out.println(users);
        System.out.println(searchedActivities);
        System.out.println(User.findHobbyLovers(users, searchedActivities));
    }

    public static List<User> generateUsers(int count) {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();

        for (var i = 0; i < count; i++) {
            String name = faker.name().firstName();
            int age = faker.number().numberBetween(18, 60);

            int activitiesCount = faker.number().numberBetween(1, 3);
            Set<String> activities = generateActivities(activitiesCount);

            users.add(new User(i, name, age, activities));
        }

        return users;
    }

    public static Set<String> generateActivities(int count) {
        Faker faker = new Faker();
        Set<String> activities = new HashSet<>();

        for (var i = 0; i < count; i++) {
            String activity = faker.esports().game();
            activities.add(activity);
        }

        return activities;
    }
}
