package school.faang.groupUsers;

import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {

    List<User> users = List.of(
        new User("Nikita", 21, "java Bootcamp", "Voronezh"),
        new User("Vlad", 21, "developer", "Moscow"),
        new User("Dima", 21, "java Bootcamp", "Moscow"),
        new User("Katia", 22, "hospital", "Voronezh"),
        new User("Maxim", 33, "factory", "Moscow")
    );

    System.out.println(users);

    Map<Integer, List<User>> groupUser = User.groupUsers(users);

    System.out.println(groupUser);
  }
}
