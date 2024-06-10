package faang.school.godbless.collector;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgenii Malkov
 */
public class Main {

  public static void main(String[] args) {
    Set<String> activities = new HashSet<>(){{
      add("football");
      add("basketball");
      add("golf");
      add("volleyball");
      add("hockey");
    }};
    User test1 = new User(1, "Test1", 18, new HashSet<>(){{add("fishing");}});
    List<User> users = List.of(
        test1,
        new User(2, "Test2", 22, new HashSet<>(){{add("fishing"); add("golf");}}),
        new User(3, "Test3", 25, new HashSet<>(){{add("moto");}}),
        new User(4, "Test4", 99, new HashSet<>(){{add("moto"); add("fishing"); add("football");}})
    );

    Map<User, String> map = test1.findHobbyLovers(users, activities);
    System.out.println(map.toString());
  }
}
