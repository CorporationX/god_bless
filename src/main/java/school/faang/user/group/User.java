package school.faang.user.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

  private String name;
  private int age;
  private String workplace;
  private String address;

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> groups = new HashMap<>();
    for (User user : users) {
      int age = user.getAge();
      List<User> userList = groups.computeIfAbsent(age, k -> new ArrayList<>());
      userList.add(user);
    }
    return groups;
  }
}
