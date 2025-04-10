package school.faang.userhobbies;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static List<User> createTestUsers() {
        User user1 = User.builder()
                .id(1)
                .name("Андрей")
                .age(35)
                .activities(Set.of("Плавание", "Музыка", "Хоккей"))
                .build();
        User user2 = User.builder()
                .id(2)
                .name("Сергей")
                .age(30)
                .activities(Set.of("Рисование", "Музыка", "Хоккей"))
                .build();
        User user3 = User.builder()
                .id(3)
                .name("Георгий")
                .age(22)
                .activities(Set.of("Бег", "Музыка", "Стрельба"))
                .build();

        List<User> users = List.of(user1, user2, user3);

        return users;
    }

    public static List<User> findHobbyLovers(List<User> users, Set<String> hobbies) {
        List<User> result = new ArrayList<>();

        for (User user : users) {

            for (String hobby : user.getActivities()) {
                if (user.getActivities().stream().anyMatch(hobbies::contains)) {
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
        hobbyLovers.forEach(user -> System.out.println(user.getName()));
    }
}