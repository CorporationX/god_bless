package tasks.bjs2_31534;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsers();
        List<String> hobbyLovers = Arrays.asList("Плавание", "Шахматы", "Футбол", "Танцы");
        System.out.println();
        showUsers(users);
        System.out.println();
        showHobbyLovers(hobbyLovers);
        System.out.println();
        showUsersHobbyLovers(User.findHobbyLovers(users, hobbyLovers));
    }

    public static List<User> getUsers() {
        return Arrays.asList(
                new User(1, "Алексей", 25, Arrays.asList("Футбол", "Шахматы", "Бег")),
                new User(2, "Дмитрий", 32, Arrays.asList("Рыбалка", "Чтение", "Плавание")),
                new User(3, "Сергей", 27, Arrays.asList("Горные лыжи", "Велоспорт")),
                new User(4, "Анна", 24, Arrays.asList("Йога", "Танцы", "Плавание")),
                new User(5, "Мария", 30, Arrays.asList("Плавание", "Волейбол")),
                new User(6, "Екатерина", 29, Arrays.asList("Рисование", "Шахматы", "Пение")),
                new User(7, "Иван", 35, Arrays.asList("Кулинария", "Футбол")),
                new User(8, "Ольга", 28, Arrays.asList("Теннис", "Йога")),
                new User(9, "Андрей", 31, Arrays.asList("Футбол", "Велоспорт")),
                new User(10, "Наталья", 26, Arrays.asList("Шахматы", "Чтение", "Плавание"))
        );
    }

    public static void showUsers(List<User> users) {
        System.out.println("Список пользователей и их хобби : ");
        for (User user : users) {
            System.out.println(user.getInformation());
        }
    }

    public static void showHobbyLovers(List<String> hobbyLovers) {
        System.out.println("Cписок любимых хобби : ");
        for (String hobby : hobbyLovers) {
            System.out.println(hobby);
        }
    }

    public static void showUsersHobbyLovers(Map<User, String> usersHobbyLovers) {
        for (Map.Entry<User, String> entry : usersHobbyLovers.entrySet()) {
            System.out.println(
                    String.format("Любимое хобби пользователя %s : %s", entry.getKey().getName(), entry.getValue())
            );
        }
    }
}

