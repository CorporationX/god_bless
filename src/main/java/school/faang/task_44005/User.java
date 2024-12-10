package school.faang.task_44005;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String name;
  private Integer age;
  private String workplace;
  private String address;

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    if (users == null || users.isEmpty()) {
      return Map.of();
    }
    return users
        .stream()
        .collect(Collectors.groupingBy(User::getAge));
  }

  @Override
  public String toString() {
    return String.format("User{name='%s', age=%d, workplace='%s', address='%s'}",
        name, age, workplace, address);
  }
}
