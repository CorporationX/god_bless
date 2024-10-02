package school.faang.godbless.bjs2_28996;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

  private String name;
  private int age;
  private String job;
  private String address;

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> usersMap = new HashMap<>();
    for (User user : users) {
      usersMap.computeIfAbsent(user.age, k -> new ArrayList<>());
      List<User> usersList = usersMap.get(user.age);
      usersList.add(user);
    }
    return usersMap;
  }
}
