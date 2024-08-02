package faang.school.godbless.BJS2_18397;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> user1Set = new HashSet<>();
        Set<String> user2Set = new HashSet<>();
        Set<String> user3Set = new HashSet<>();
        Set<String> user4Set = new HashSet<>();
        Set<String> listActivities = new HashSet<>();

        listActivities.add("Рыбалка");
        listActivities.add("Велосипед");
        listActivities.add("Хоккей");
        listActivities.add("Плавание");
        listActivities.add("Готовка");
        listActivities.add("Садоводство");
        listActivities.add("Парапланеризм");
        listActivities.add("Ходьба");
        listActivities.add("Программирование");

        user1Set.add("Рыбалка");
        user1Set.add("Велосипед");
        user1Set.add("Хоккей");

        user2Set.add("Футбол");
        user2Set.add("Бег");
        user2Set.add("Рисование");

        user3Set.add("Плавание");
        user3Set.add("Готовка");
        user3Set.add("Садоводство");

        user4Set.add("Парапланеризм");
        user4Set.add("Бег");
        user4Set.add("Рисование");

        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Денис", 39, new HashSet<>(user1Set));
        User user2 = new User(2, "Михаил", 19, new HashSet<>(user2Set));
        User user3 = new User(3, "Галина", 35, new HashSet<>(user3Set));
        User user4 = new User(4, "Светлана", 30, new HashSet<>(user4Set));
        User user5 = new User(5, "Тимофей", 25, new HashSet<>(user1Set));

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        Map<User, String> resultMap = User.findHobbyLovers(userList, listActivities);
        for (Map.Entry<User, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }

    }
}
