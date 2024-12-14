package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
  private String name;
  private int age;
  private String job;
  private String address;
  private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
  private final Set<String> VALID_ADDRESSES = Set.of( "London", "New York", "Amsterdam");

  public User(String name, int age, String job, String address) {
    this.setName(name);
    this.setAge(age);
    this.setJob(job);
    this.setAddress(address);
  }

  public void setName(String name) {
    if (name.isEmpty())
      throw new IllegalArgumentException("Name cannot be empty");
    this.name = name;
  }

  public void setAge(int age) {
    if (age < 18)
      throw new IllegalArgumentException("age cannot be less than 18");
    this.age = age;
  }

  public void setJob(String job) {
    if (!VALID_JOBS.contains(job))
      throw new IllegalArgumentException("Not valid company");
    this.job = job;
  }

  public void setAddress(String address) {
    if (!VALID_ADDRESSES.contains(address))
      throw new IllegalArgumentException("Not valid address");
    this.address = address;
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> result = new HashMap<>();
    for (User user: users) {
      if (!result.containsKey(user.getAge()))
        result.put(user.getAge(), new ArrayList<>());

      result.get(user.getAge()).add(user);
    }
    return result;
  }
}
