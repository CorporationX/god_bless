package school.faang.sprint1.task_44023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        User sergeyS = new User(1, "Сергей Срегеев", 25, new HashSet<>(Arrays.asList("Футбол", "Музыка", "Чтение")));
        User mariaP = new User(2, "Мария Петрова", 30, new HashSet<>(Arrays.asList("Плавание", "Музыка", "Танцы")));
        User alexeyS = new User(3, "Алексей Сидоров", 20, new HashSet<>(Arrays.asList("Программирование", "Шахматы")));
        User annaS = new User(4, "Анна Смирнова", 28, new HashSet<>(Arrays.asList("Йога", "Футбол", "Рисование")));

        List<User> users = Arrays.asList(sergeyS, mariaP, alexeyS, annaS);

        Set<String> targetHobbies = new HashSet<>(Arrays.asList("Футбол", "Музыка", "Йога"));

        Map<User, String> result = User.findHobbyLovers(users, targetHobbies);

        System.out.println("Пользователи, увлекающиеся целевыми активностями:");
        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

