package faang.school.godbless.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс Пользователь
 */
@Data
@AllArgsConstructor
public class User {

  private Integer id;
  private String name;
  private Integer age;
  private Set<String> hobbies;

  /**
   * Метод для нахождения одинакового хобби у списка пользователей.
   * @param users список пользователей.
   * @param hobbyLovers список хобби.
   * @return Map, которая содержить только пользователей у которых есть схожие хобби.
   */
  public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbyLovers) {
    Map<User, String> resultHobbyLovers = new HashMap<>();
    users.forEach(user -> resultHobbyLovers.computeIfAbsent(user, currentUser -> hobbyLovers
        .stream()
        .filter(hobby -> currentUser.hobbies.contains(hobby))
        .findFirst()
        .orElse(null)
    ));
    return resultHobbyLovers;
  }

}
