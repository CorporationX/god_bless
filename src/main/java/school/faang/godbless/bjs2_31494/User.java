package school.faang.godbless.bjs2_31494;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import lombok.Data;

@Data
public class User {

  private int id;
  private String name;
  private int age;
  private Set<String> activities;

  public User(int id, String name, int age, Set<String> activities) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.activities = activities;
  }

  public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
    Map<User, String> result = new HashMap<>();
    for (User u : users) {
      Set<String> userActivities = u.activities;

      for (String activity : userActivities) {
        if (activities.contains(activity)) {
          result.put(u, activity);
          break;
        }
      }
    }
    return result;
  }
}
