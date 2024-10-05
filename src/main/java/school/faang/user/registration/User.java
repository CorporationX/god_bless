package school.faang.user.registration;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {

  private static final int VALID_AGE = 18;
  private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
  private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

  private String name;
  private int age;
  private String workplace;
  private String address;

  public User(String name, int age, String workplace, String address) {
    String incorrectData = invalidData(name, age, workplace, address);
    if (!incorrectData.isEmpty()) {
      throw new IllegalArgumentException(incorrectData);
    }
    this.name = name;
    this.age = age;
    this.workplace = workplace;
    this.address = address;
  }

  private static String invalidData(String name, int age, String workplace, String address) {
    if (name.isEmpty()) {
      return "Missing name";
    }
    if (age < VALID_AGE) {
      return "incorrect age: " + age;
    }
    if (!VALID_JOBS.contains(workplace)) {
      return "incorrect workplace: " + workplace;
    }
    if (!VALID_ADDRESSES.contains(address)) {
      return "incorrect address: " + workplace;
    }
    return "";
  }

}
