package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * класс для отображения данных о пользователе.
 */
@Data
public class User {
  private static final String MESSAGE_VALIDATION_EXCEPTION = "Ошибка валидации при добавлении пользователя.";
  private static final Integer MIN_AGE_FOR_WORKS = 18;
  private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
  private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

  private String userName;
  private Integer userAge;
  private String userWorkplace;
  private String userAddress;

  public User(String userName, Integer userAge, String userWorkplace, String userAddress) {
    var resultUserName = userName.trim();
    var resultUserWorkplace = userWorkplace.trim();
    var resultUserAddress = userAddress.trim();
    if (resultUserName.isEmpty() || userAge < MIN_AGE_FOR_WORKS ||
        !VALID_JOBS.contains(resultUserWorkplace) || !VALID_ADDRESSES.contains(resultUserAddress)) {
     throw new IllegalArgumentException(MESSAGE_VALIDATION_EXCEPTION);
    } else {
      this.userName = resultUserName;
      this.userAge = userAge;
      this.userWorkplace = resultUserWorkplace;
      this.userAddress = resultUserAddress;
    }
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
