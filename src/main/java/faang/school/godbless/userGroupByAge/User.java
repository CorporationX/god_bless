package faang.school.godbless.userGroupByAge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
@ToString
public class User {
  private String name;
  private Integer age;
  private String company;
  private String address;

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    return users.stream().collect(Collectors.groupingBy(User::getAge));
  }
}
