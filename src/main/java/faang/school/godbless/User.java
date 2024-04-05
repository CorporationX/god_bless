package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
  private int id;
  private String name;
  private int age;
  private Set<String> activities;

  private Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
    Map<User, String> result = new HashMap<>();
    for (User user : users) {
      for (String act: user.activities) {
        if (activities.contains(act)) {
          result.put(user, act);
          break;
        }
      }
    }
    return result;
  }
}
