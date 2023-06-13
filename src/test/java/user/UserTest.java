package user;

import faang.school.godbless.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
  private User user;
  private final static String FIRST_NAME = "First name";
  private final static int AGE = 20;
  private final static String JOB = "Google";
  private final static String ADDRESS = "London";
  private final static Set<String> ACTIVITIES = Set.of("Running", "Swimming", "Jumping");


  @BeforeEach
  public void setUp() {
    user = new User(FIRST_NAME, AGE, JOB, ADDRESS, ACTIVITIES);
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
      new User("", 22, "Google", "London", ACTIVITIES);
    });

    assertEquals(User.REQUIRED_NAME_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputAge() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new User("Max", 15, "Google", "London", ACTIVITIES);
    });

    assertEquals(User.MIN_AGE_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputJob() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new User("Max", 25, "Twtitter", "London", ACTIVITIES);
    });

    assertEquals(User.VALID_JOBS_ERROR, exception.getMessage());
  }

  @Test
  public void testCorrectInputAddress() {
    try {
      User user = new User("Max", 25, "Google", "Kyiv", ACTIVITIES);
      // If code above will be executed without errors - it's a problem, we should have age validation
      throw new IllegalArgumentException("Should not be executed");
    } catch (Exception e) {
      assertEquals(User.VALID_ADDRESSES_ERROR, e.getMessage());
    }
  }

  @Test
  public void testGroupUsers() {
    User dima = new User("Dima", 21, "Google", "London", ACTIVITIES);
    User max = new User("Max", 20, "Uber", "New York", ACTIVITIES);
    User alex = new User("Alex", 21, "Amazon", "Amsterdam",ACTIVITIES);
    User petr = new User("Petr", 20, "Google", "London", ACTIVITIES);
    User bryan = new User("Bryan", 19, "Uber", "Amsterdam", ACTIVITIES);

    List<User> users = List.of(dima, max, alex, petr, bryan);

    Map<Integer, List<User>> expectedGroups = new HashMap<Integer, List<User>>();

    expectedGroups.put(19, List.of(bryan));
    expectedGroups.put(20, List.of(max, petr));
    expectedGroups.put(21, List.of(dima, alex));

    Map<Integer, List<User>> actualUsersAgeToUsersResult = User.groupUsers(users);

    assertEquals(expectedGroups, actualUsersAgeToUsersResult);
  }

  @Test
  public void findHobbyLoversTest() {
    Map<User, String> expectedActivityResult = new HashMap<>();
    User max = new User("Max", 19, "Google", "London", Set.of("Running"));
    User matt = new User("Matt", 21, "Uber", "London", Set.of("Jumping"));
    expectedActivityResult.put(max, "Running");
    expectedActivityResult.put(matt, "Jumping");

    Map<User, String> actualActivityResult = User.findHobbyLovers(List.of(max, matt), Set.of("Running", "Swimming", "Jumping"));
    assertEquals(expectedActivityResult, actualActivityResult);
  }
}
