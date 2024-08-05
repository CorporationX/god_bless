package faang.school.godbless.BJS2_18397;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> listActivities = Set.of("Рыбалка","Велосипед","Хоккей","Плавание",
                "Готовка","Садоводство","Парапланеризм","Ходьба","Программирование");

        User denis = new User(1, "Денис", 39, Set.of("Рыбалка","Велосипед","Хоккей"));
        User michael = new User(2, "Михаил", 19, Set.of("Футбол","Бег","Рисование"));
        User galina = new User(3, "Галина", 35, Set.of("Плавание","Готовка","Садоводство"));
        User svetlana = new User(4, "Светлана", 30, Set.of("Парапланеризм","Бег","Рисование"));
        User timofey = new User(5, "Тимофей", 25, Set.of("Рыбалка","Велосипед","Хоккей"));

        List<User> userList = List.of(denis,michael,timofey,galina,svetlana);

        Map<User, String> resultMap = User.findHobbyLovers(userList, listActivities);
        for (Map.Entry<User, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
