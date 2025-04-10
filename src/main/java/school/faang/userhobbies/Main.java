package school.faang.userhobbies;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.userhobbies.User.findHobbyLovers;

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

        return List.of(user1, user2, user3);
    }

    public static void main(String[] args) {
        List<User> users = createTestUsers();
        Set<String> targetHobbies = Set.of("Музыка");
        Map<User, String> hobbyLovers = findHobbyLovers(users, targetHobbies);
        hobbyLovers.forEach((user, hobby) -> System.out.printf("%s : %s", user.getName(), hobby + "\n"));
    }
}