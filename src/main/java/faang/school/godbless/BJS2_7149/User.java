package faang.school.godbless.BJS2_7149;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
  private long id;
  private String name;
  private int age;
  private List<String> activities;

  public static Map<User, String> findHobbyLovers(List<User> users, List<String> activities) {
    Map<User, String> result = new HashMap<>();
    for (User user: users) {
      for (String activity : user.getActivities()) {
        if (activities.contains(activity)) {
          result.put(user, activity);
          break;
        }
      }
    }
    return result;
  }
}
