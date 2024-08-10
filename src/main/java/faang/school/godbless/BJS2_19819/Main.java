package faang.school.godbless.BJS2_19819;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//добавление нового пользователя и его списка запросов;
//добавление нового запроса для существующего пользователя;

//удаление пользователя и его списка запросов;
//вывод списка всех пользователей и их запросов.
//Реализуйте метод для вывода истории запросов пользователя, используя обход массива Entry внутри HashMap.
//Выведите имя пользователя и его запросы, отсортированные по времени создания запроса.


public class Main {
    private static final Map<User, List<Query>> userQueries = new HashMap<>();

    public static void main(String[] args) {
        addUserQueries(new User(0, "Viktor"), new ArrayList<>() {{
            new Query(0, "ViktorQuery1", LocalDateTime.now());
            new Query(1, "ViktorQuery2", LocalDateTime.now());
            new Query(2, "ViktorQuery3", LocalDateTime.now());
        }});
        addUserQueries(new User(1, "Petr"), new ArrayList<>() {{
            new Query(0, "PetrQuery1", LocalDateTime.now());
            new Query(1, "PetrQuery2", LocalDateTime.now());
            new Query(2, "PetrQuery3", LocalDateTime.now());
        }});
        addUserQueries(new User(2, "Ivan"), new ArrayList<>() {{
            new Query(0, "IvanQuery1", LocalDateTime.now());
            new Query(1, "IvanQuery2", LocalDateTime.now());
            new Query(2, "IvanQuery3", LocalDateTime.now());
        }});


    }

    public static void addUserQueries(User user, List<Query> queries) {
        userQueries.put(user, queries);
    }

    public static void addQueryCurrUser(User user, Query query) {
        userQueries.computeIfPresent(user, (key, listQueries) -> {
            listQueries.add(query);
            return listQueries;
        });
    }

    public static void removeUser(User user) {

    }

    public static void printAllUsers() {

    }

}
