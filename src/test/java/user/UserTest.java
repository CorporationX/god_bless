package user;

import faang.school.godbless.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
  private User user;
  private final static String FIRST_NAME = "First name";
  private final static int AGE = 20;
  private final static String JOB = "Google";
  private final static String ADDRESS = "London";


  @BeforeEach
  public void setUp() {
    user = new User(FIRST_NAME, AGE, JOB, ADDRESS);
  }

  @Test
  public void testUserConstructor() {
    assertEquals(FIRST_NAME, user.getName());
    assertEquals(AGE, user.getAge());
    assertEquals(JOB, user.getJob());
    assertEquals(ADDRESS, user.getAddress());
  }

  @Test
  public void testCorrectInputName() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new User("", 22, "Google", "London");
    });

    assertEquals(User.REQUIRED_NAME_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputAge() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new User("Max", 15, "Google", "London");
    });

    assertEquals(User.MIN_AGE_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputJob() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new User("Max", 25, "Twtitter", "London");
    });

    assertEquals(User.VALID_JOBS_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputAddress() {
    try {
      User user = new User("Max", 25, "Google", "Kyiv");
      // If code above will be executed without errors - it's a problem, we should have age validation
      throw new IllegalArgumentException("Should not be executed");
    } catch (Exception e) {
      assertEquals(User.VALID_ADDRESSES_ERROR, e.getMessage());
    }
  }

  @Test
  public void testGroupUsers() {
    User dima = new User("Dima", 21, "Google", "London");
    User max = new User("Max", 20, "Uber", "New York");
    User alex = new User("Alex", 21, "Amazon", "Amsterdam");
    User petr = new User("Petr", 20, "Google", "London");
    User bryan = new User("Bryan", 19, "Uber", "Amsterdam");

    List<User> users = List.of(dima, max, alex, petr, bryan);

    Map<Integer, List<User>> expectedGroups = new HashMap<Integer, List<User>>();

    expectedGroups.put(19, List.of(bryan));
    expectedGroups.put(20, List.of(max, petr));
    expectedGroups.put(21, List.of(dima, alex));

    Map<Integer, List<User>> actualUsersAgeToUsersResult = User.groupUsers(users);

    assertEquals(expectedGroups, actualUsersAgeToUsersResult);
  }
}
