package faang.school.godbless.collector;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class User {
  private int id;
  private String name;
  private int age;
  private Set<String> activities;

  public Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbySet) {
    return users.stream()
        .filter(user -> user.getActivities().stream().anyMatch(hobbySet::contains))
        .collect(Collectors.toMap((user) -> user, (user) -> user.getActivities().stream()
            .filter(hobbySet::contains)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Can't find the same activities"))));
  }
}
