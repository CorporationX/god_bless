package faang.school.godbless.BJS2_7554;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<User> users = List.of(new User("1", 10, "2", "3"),
      new User("2", 10, "2", "3"),
      new User("3", 15, "2", "3"),
      new User("4", 15, "2", "3"),
      new User("5", 13, "2", "3"));

    System.out.println(User.groupUsers(users));
  }
}
