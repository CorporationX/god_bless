package faang.school.godbless.validtionUser;

import java.util.List;

/**
 * @author Evgenii Malkov
 */
public class Main {
  public static void main(String[] args) {
    List<User> users = List.of(
        new User("", 18, "Google", "Amsterdam"),
        new User("Евгений", 17, "Uber", "New York"),
        new User("Евгений", 27, "TestCompany", "London"),
        new User("Евгений", 27, "Amazon", "Moscow")
    );
  }
}
