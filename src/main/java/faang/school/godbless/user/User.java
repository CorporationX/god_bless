package faang.school.godbless.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
  private String name;
  private int age;
  private String job;
  private String address;

  public User(String name, int age, String job, String address) {
    this.name = name;
    this.age = age;
    this.job = job;
    this.address = address;
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> userAgeToUsers = new HashMap<Integer, List<User>>();

    for (User user : users) {
      if (userAgeToUsers.containsKey(user.age)) {
        userAgeToUsers.get(user.age).add(user);
      } else {
        List<User> newUsers = new ArrayList<User>();
        newUsers.add(user);

        userAgeToUsers.put(user.age, newUsers);
      }
    }

    return userAgeToUsers;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getJob() {
    return job;
  }

  public String getAddress() {
    return address;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
