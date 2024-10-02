package school.faang.godbless.bjs2_28996;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Data;

@Data
public class User {

  private static final Set<String> VALID_JOBS = new HashSet<>();
  private static final Set<String> VALID_ADDRESSES = new HashSet<>();

  private String name;
  private int age;
  private String job;
  private String address;

  static {
    VALID_JOBS.add("Google");
    VALID_JOBS.add("Uber");
    VALID_JOBS.add("Amazon");

    VALID_ADDRESSES.add("London");
    VALID_ADDRESSES.add("York");
    VALID_ADDRESSES.add("Amsterdam");
  }

  public User(String name, int age, String job, String address) {
    validateName(name);
    validateAge(age);
    validateJob(job);
    validateAddress(address);

    this.name = name;
    this.age = age;
    this.job = job;
    this.address = address;
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> usersMap = new HashMap<>();
    for (User user : users) {
      usersMap.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
    }
    return usersMap;
  }

  private static void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
  }

  private static void validateAge(int age) {
    if (age < 18) {
      throw new IllegalArgumentException("Age can not be less than 18");
    }
  }

  private static void validateJob(String job) {
    if (!VALID_JOBS.contains(job)) {
      throw new IllegalArgumentException("Job " + job + " is not in the valid jobs list");
    }
  }

  private static void validateAddress(String address) {
    if (!VALID_ADDRESSES.contains(address)) {
      throw new IllegalArgumentException("Address " + address + " is not in the valid addressed list");
    }
  }
}
