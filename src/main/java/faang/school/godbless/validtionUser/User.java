package faang.school.godbless.validtionUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@Getter
@ToString
public class User {
  private static final int MIN_AGE = 18;
  private static final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
  private static final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));

  private String name;
  private int age;
  private String company;
  private String address;

  public User(String name, int age, String company, String address) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    if (age < MIN_AGE) {
      throw new IllegalArgumentException(String.format("Age cannot be less than %s", MIN_AGE));
    }
    if (!VALID_JOBS.contains(company)) {
      throw new IllegalArgumentException("Invalid company name");
    }
    if (!VALID_ADDRESSES.contains(address)) {
      throw new IllegalArgumentException("Invalid address");
    }

    this.name = name;
    this.age = age;
    this.company = company;
    this.address = address;
  }
}
