package faang.school.godbless.BJS2_7149;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<User> users = List.of(
      new User(1, "1", 18, List.of("a", "b", "c")),
      new User(2, "2", 22, List.of("c", "a")),
      new User(3, "3", 38, List.of("d", "b")),
      new User(4, "4", 40, List.of("a", "d"))
    );
    List<String> activities = List.of("c", "b");

    System.out.println(User.findHobbyLovers(users, activities));
  }
}
