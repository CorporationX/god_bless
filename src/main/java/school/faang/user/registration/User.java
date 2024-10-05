package school.faang.user.registration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class User {

  private String name;
  private int age;
  private String workplace;
  private String address;

  private static final Set<String> VALID_JOBS = new HashSet<>(
      Arrays.asList("Google", "Uber", "Amazon"));
  private static final Set<String> VALID_ADDRESSES = new HashSet<>(
      Arrays.asList("London", "New York", "Amsterdam"));

  public User(String name, int age, String workplace, String address) {
    if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(workplace)
        || !VALID_ADDRESSES.contains(address)) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.age = age;
    this.workplace = workplace;
    this.address = address;
  }

}
