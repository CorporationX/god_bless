package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    @Getter
    static class User {

        private final int id;
        private final String name;
        private final int age;
        private final Set<String> activities;

        public User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.activities = new HashSet<>();
        }

        public void addActivity(String activity) {
            activities.add(activity);
        }

    }

    private static List<User> createTestUsers() {

        User user1 = new User(1, "Андрей", 25);
        user1.addActivity("Плавание");
        user1.addActivity("Чтение");
        user1.addActivity("Хоккей");

        User user2 = new User(2, "Сергей", 30);
        user2.addActivity("Рисование");
        user2.addActivity("Музыка");
        user2.addActivity("Хоккей");

        User user3 = new User(3, "Георгий", 28);
        user3.addActivity("Бег");
        user3.addActivity("Стрельба");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

    public static List<User> findHobbyLovers(List<User> users, Set<String> hobbies) {
        List<User> result = new ArrayList<>();

        for (User user : users) {

            Set<String> userHobbies = user.getActivities();
            for (String hobby : hobbies) {
                if (userHobbies.contains(hobby)) {
                    result.add(user);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<User> users = createTestUsers();
        Set<String> targetHobbies = Set.of("Хоккей");

        List<User> hobbyLovers = findHobbyLovers(users, targetHobbies);

        System.out.println("Пользователи с указанными хобби в виде Хоккеея:");
        hobbyLovers.forEach(user -> System.out.println(user.getName()));
    }
}
