package faang.school.godbless.BJS2_4341;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        Set<String> activities = new HashSet<>(Set.of("Бег", "Загорание", "Прогулка"));

        users.add(new User(1, "Anton", 20, new HashSet<>(Set.of("Бег", "Прогулка", "Отжимания"))));
        users.add(new User(2, "Sasha", 20, new HashSet<>(Set.of("Вышевка", "Готовка", "Бег"))));
        users.add(new User(3, "Zhenya", 20, new HashSet<>(Set.of("Сон", "Отдых", "Трапеза"))));

        Map<User, String> findHobbyLoversMap = User.findHobbyLovers(users, activities);

        for (Map.Entry<User, String> entry : findHobbyLoversMap.entrySet()){
            System.out.println("Пользователь: " + entry.getKey().getName() + ", активность: " + entry.getValue());
        }
    }
}
