package school.faang.task_bjs_44005;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    User john = new User("John", 55, "Google LC",
        "USA, California, 1600 Amphitheatre Parkway in Mountain View");
    User elon = new User("Elon", 55, "X.com",
        "USA, California");
    User sam = new User("Sam", 25, "Facebook", "USA, California, Hacker Way, Menlo Park");
    User jennie = new User("Jennie", 28, "Netflix LC",
        "USA, California, Los Gatos 131 Albright Way");
    User bob = new User("Bob", 28, "Netflix LC", "USA, California, Los Gatos 131 Albright Way");

    List<User> users = List.of(john, elon, sam, jennie, bob);
    System.out.printf("Список пользователей по возрасту: %n%s%n",
        User.groupUsers(users));
  }
}
