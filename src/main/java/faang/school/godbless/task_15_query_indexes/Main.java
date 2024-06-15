package faang.school.godbless.task_15_query_indexes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<User, List<Query>> userQuaryMap = new HashMap<>();

    public static void main(String[] args) {
        // Создание пользователей
        int userCount = 0;
        User sergUser = new User(++userCount, "Serg");
        User kateUser = new User(++userCount, "Kate");
        User maryUser = new User(++userCount, "Mary");

        // Добавление пользователей
        addUser(sergUser);
        addUser(kateUser);
        addUser(maryUser);

        //Создание и добавление запросов
        int queryCount = 0;
        addQuery(sergUser, new Query(++queryCount, "Как бросить курить", LocalDate.now()));
        addQuery(kateUser, new Query(++queryCount, "Как вывести ржаную закваску", LocalDate.now()));
        addQuery(kateUser, new Query(++queryCount, "Рецепт кваса", LocalDate.now()));
        addQuery(maryUser, new Query(++queryCount, "трололо", LocalDate.now()));
        addQuery(sergUser, new Query(++queryCount, "поздно ли сажать редиску", LocalDate.now()));
        addQuery(maryUser, new Query(++queryCount, "синий трактор", LocalDate.now()));
        addQuery(sergUser, new Query(++queryCount, "курс доллара", LocalDate.now()));
        addQuery(kateUser, new Query(++queryCount, "Когда ребёнок начинает ходить", LocalDate.now()));
        addQuery(sergUser, new Query(++queryCount, "где найти время на сон", LocalDate.now()));
        addQuery(maryUser, new Query(++queryCount, "ывадрыа", LocalDate.now()));

        // Вывод запросов пользователя
        System.out.println("Список запросов serg.");
        showQueries(sergUser);

        // Удаление пользователя и его запросов
        System.out.println("\nserg удалён.");
        removeUser(sergUser);

        // Вывод всех пользователей и их запросов
        System.out.println("\nВывод всех пользователей и их запросов.");
        showAllUserAndQuery();
    }

    /**
     * Удаление пользователя с его запросами
     *
     * @param user
     */
    private static void removeUser(User user) {
        userQuaryMap.remove(user);
    }

    /**
     * Вывод всех пользователей и их запросов
     */
    private static void showAllUserAndQuery() {
        for (User user : userQuaryMap.keySet()) {
            showQueries(user);
        }
    }

    /**
     * Вывод запросов пользователя
     *
     * @param user
     */
    private static void showQueries(User user) {
        System.out.println(user.name());
        for (Query query : userQuaryMap.get(user)) {
            System.out.println(query.content());
        }
    }

    /**
     * Добавление запроса пользователя в хэш
     *
     * @param user
     * @param query
     */
    private static void addQuery(User user, Query query) {
        if (!userQuaryMap.containsKey(user)) {
            addUser(user);
        }
        userQuaryMap.get(user).add(query);
    }

    /**
     * Добавление пользователя
     *
     * @param user
     */
    private static void addUser(User user) {
        userQuaryMap.put(user, new ArrayList<>());
    }
}
