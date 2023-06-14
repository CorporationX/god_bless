package faang.school.godbless.user;

import java.util.*;

public class User {
  private String name;
  private int age;
  private String job;
  private String address;
  private Set<String> activities;
  private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
  private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

  public static final int MIN_AGE = 18;
  public static final String REQUIRED_NAME_ERROR = "Name is required";
  public static final String MIN_AGE_ERROR = "Age should be more than " + MIN_AGE;
  public static final String VALID_JOBS_ERROR = "Job should be on of the: " + String.join(",", VALID_JOBS);
  public static final String VALID_ADDRESSES_ERROR = "Job should be on of the: " + String.join(",", VALID_ADDRESSES);

  private void validateInputName(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException(REQUIRED_NAME_ERROR);
    }
  }

  private void validateInputAge(int age) {
    if (age < MIN_AGE) {
      throw new IllegalArgumentException(MIN_AGE_ERROR);
    }
  }

  private void validateInputJob(String job) {
    if (!VALID_JOBS.stream().anyMatch(job::contains)) {
      throw new IllegalArgumentException(VALID_JOBS_ERROR);
    }
  }

  private void validateInputAddress(String job) {
    if (!VALID_ADDRESSES.contains(job)) {
      throw new IllegalArgumentException(VALID_ADDRESSES_ERROR);
    }
  }

  private void validateInputData(String name, int age, String job, String address) {
    validateInputName(name);
    validateInputAge(age);
    validateInputJob(job);
    validateInputAddress(address);
  }

  public User(String name, int age, String job, String address, Set<String> activities) {
    validateInputData(name, age, job, address);

    this.name = name;
    this.age = age;
    this.job = job;
    this.address = address;
    this.activities = activities;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User user)) return false;
    return age == user.age && Objects.equals(name, user.name) && Objects.equals(job, user.job) && Objects.equals(address, user.address) && Objects.equals(activities, user.activities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, job, address, activities);
  }

  public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
    Map<User, String> mapUserToActivity = new HashMap<>();

    for (User user : users) {
      for (String activity : activities) {
        if (user.activities.contains(activity)) {
          mapUserToActivity.put(user, activity);
          break;
        }
      }
    }

    return mapUserToActivity;
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
