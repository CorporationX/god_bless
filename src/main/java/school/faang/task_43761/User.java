package school.faang.task_43761;

import static java.lang.Boolean.FALSE;

import lombok.Data;

@Data
public class User {

  private String name;
  private int age;
  private String job;
  private String address;

  public User(String name, int age, String job, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    this.name = name;
    if (age < 18) {
      throw new IllegalArgumentException("Age cannot be less than 18");
    }
    this.age = age;

    if (FALSE.equals(Constants.VALID_JOBS.contains(job))) {
      throw new IllegalArgumentException(String.format("Invalid job for: %s", job));
    }
    this.job = job;

    if (FALSE.equals(Constants.VALID_ADDRESSES.contains(address))) {
      throw new IllegalArgumentException(String.format("Invalid address: %s", address));
    }
    this.address = address;
  }
}
