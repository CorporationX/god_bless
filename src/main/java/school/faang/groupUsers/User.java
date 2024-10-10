package school.faang.groupUsers;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
  final private String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
  final private String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

  final int MINIMAL_AGE = 18;

  private String name;
  private int age;
  private String placeOfWork;
  private String address;

  User(String name, int age, String placeOfWork, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (age < MINIMAL_AGE) {
      throw new IllegalArgumentException("Age cannot be less than " + MINIMAL_AGE + " years");
    }
    if (!Arrays.asList(VALID_JOBS).contains(placeOfWork)) {
      throw new IllegalArgumentException("place of work not exist in the valid list, expected: " + Arrays.toString(VALID_JOBS));
    }
    if (!Arrays.asList(VALID_ADDRESSES).contains(address)) {
      throw new IllegalArgumentException("address not exist in the valid list, expected: " + Arrays.toString(VALID_ADDRESSES));
    }

    this.name = name;
    this.age = age;
    this.placeOfWork = placeOfWork;
    this.address = address;
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> groupUsers = new HashMap<>();

    for (User user : users) {
      groupUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
    }

    return groupUsers;
  }
}