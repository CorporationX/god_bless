package faang.school.godbless.elk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final String USER_VALUE = "User: ";
  private static final String QUERY_VALUE = "Query: ";

  private static final Map<User, List<Query>> map = new HashMap<>();

  public static void main(String[] args) {
    User user = new User(1, "Пользователь");
    Query firstQuery = new Query(1, "Запрос № 1", new Date(1720000000000L));
    Query secondQuery = new Query(2, "Запрос № 2", new Date(1722607006000L));
    Query thirdQuery = new Query(3, "Запрос № 3", new Date(1719040504000L));
    Query fourthQuery = new Query(4, "Запрос № 4", new Date(1718240500000L));

    List<Query> listQueries = new ArrayList<>(List.of(firstQuery, secondQuery));

    addUser(user, listQueries);
    addQueryForUser(user, thirdQuery);
    addQueryForUser(user, fourthQuery);
    showAllUsers();
    showHistoryQueryUsers();
  }

  /**
   * Метод добавления нового пользователя и его списка запросов
   * @param user Пользователель
   * @param queries Список запросов.
   */
  private static void addUser(User user, List<Query> queries) {
    map.putIfAbsent(user, queries);
  }

  /**
   * Метод добавления нового запроса для существующего пользователя
   * @param user Пользователь
   * @param query Запрос пользователя
   */
  private static void addQueryForUser(User user, Query query) {
    map.computeIfPresent(user, (key, list) -> {
      list.add(query);
      return list;
    });
  }

  /**
   * Метод удаляет пользователя и его списка запросов.
   * @param user Пользователь
   */
  private static void removeUser(User user) {
    map.remove(user);
  }

  /**
   * Метод вывод списка всех пользователей и их запросов.
   */
  private static void showAllUsers() {
    map.forEach((user, query) -> System.out.println(USER_VALUE + user + QUERY_VALUE + query));
  }

  /**
   * Методод, который выводит имя пользователя и его запросы,
   * отсортированные по времени создания запроса
   */
  private static void showHistoryQueryUsers() {
    for (Map.Entry<User, List<Query>> entry : map.entrySet()) {
      Collections.sort(entry.getValue());
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }

}
