package faang.school.godbless.BJS2_7815;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
  private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
  private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
  private String name;
  private int age;
  private String workPlace;
  private String address;

  public User(String name, int age, String workPlace, String address) {
    isValid(name, age, workPlace, address);
    this.name = name;
    this.age = age;
    this.workPlace = workPlace;
    this.address = address;
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    return users.stream().collect(Collectors.groupingBy(User::getAge));
  }

  private void isValid(String name, int age, String workPlace, String address) {
    if (name.isEmpty()) throw new IllegalArgumentException("Имя не должно быть пустым");
    if (age < 18) throw new IllegalArgumentException("Возраст должен быть больше 18 лет");
    if (!VALID_JOBS.contains(workPlace)) throw new IllegalArgumentException("Место работы должно быть в списке: "
      + "\"Google\", \"Uber\", \"Amazon\" ");
    if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Адресс должне находиться в списке: "
      + "\"London\", \"New York\", \"Amsterdam\"");
  }
}

