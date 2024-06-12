package faang.school.godbless.BJS2_8366;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  static Map<User, List<Query>> users = new HashMap<>();
  public static void main(String[] args) {
    List<Query> queriesFirst = new ArrayList<>();
    queriesFirst.add(new Query(1l, "content", new Date()));
    queriesFirst.add(new Query(2l, "content2", new Date()));
    addUserAndQuery(new User(1l, "name1"), queriesFirst);
    addUserAndQuery(new User(2l, "name2"), List.of(new Query(1l, "content", new Date()),
      new Query(2l, "content2", new Date())));
    System.out.println(users);

    addQueryFromUser(new User(1l, "name1"), new Query(3l, "content3", new Date()));
    System.out.println(users);

    deleteUser(new User(2l, "name2"));
    System.out.println(users);

    printAllUsers();
    printAllQuerysFromUser(new User(1l, "name1"));
  }

  public static void addUserAndQuery(User user, List<Query> queries) {
    users.put(user, queries);
  }

  public static void addQueryFromUser(User user, Query query) {
    users.computeIfAbsent(user, s -> new ArrayList<>()).add(query);
  }

  public static void deleteUser(User user) {
    if (users.containsKey(user)) {
      users.remove(user);
    } else {
      System.out.println("По данному ключу не найден пользователь");
    }
  }

  public static void printAllUsers() {
    for (Map.Entry<User, List<Query>> entry : users.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }
  }

  public static void printAllQuerysFromUser(User user) {
    for (Map.Entry<User, List<Query>> entry : users.entrySet()) {
      if (user.equals(entry.getKey())) {
        System.out.println(user + " - " + entry.getValue().stream().sorted(Comparator.comparing(Query::getTimestamp)).toList());
      }
    }
  }
}
