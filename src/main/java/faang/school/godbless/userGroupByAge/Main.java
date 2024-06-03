package faang.school.godbless.userGroupByAge;

import java.util.List;

/**
 * @author Evgenii Malkov
 */
public class Main {
  public static void main(String[] args) {
    List<User> users = List.of(
        new User("Евгений", 27, "TestCompany", "TestAddress"),
        new User("Антон", 28, "TestCompany1", "TestAddress1"),
        new User("Дмитрий", 1, "TestCompany2", "TestAddress2"),
        new User("Владимир", 99, "TestCompany3", "TestAddress3"),
        new User("Лев", 28, "TestCompany4", "TestAddress4"),
        new User("Анатолий", 130, "TestCompany5", "TestAddress5"),
        new User("Ксения", 14, "TestCompany6", "TestAddress6"),
        new User("Екатерина", 1, "TestCompany7", "TestAddress7"),
        new User("Петр", -1, "TestCompany8", "TestAddress8"),
        new User("Олег", 28, "TestCompany9", "TestAddress9"));

    User.groupUsers(users).forEach((k, v) -> System.out.println(k + ": " + v.toString()));
  }
}
