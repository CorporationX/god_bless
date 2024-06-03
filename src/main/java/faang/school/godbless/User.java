package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * POJO класс для отображения данных о пользователе.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
  private String userName;
  private Integer userAge;
  private String userWorkplace;
  private String userAddress;

  public User(String userName, Integer userAge, String userWorkplace, String userAddress) {
    this.userName = userName;
    this.userAge = userAge;
    this.userWorkplace = userWorkplace;
    this.userAddress = userAddress;
  }

  /**
   * Метод для преобразования писока из объектов User в Map.
   * @param listUsers Список из объектов User.
   * @return Map, где ключом является возраст
   * пользователя, а значением — список из всех пользователей в оригинальном списке,
   * которые имеют соответствующий возраст.
   */
  public static Map<Integer, List<User>> convertListUserToMap(List<User> listUsers) {
    return listUsers
        .stream()
        .collect(Collectors.groupingBy(User::getUserAge, Collectors.toList()));
  }

}
