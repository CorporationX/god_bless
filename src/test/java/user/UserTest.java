package user;

import faang.school.godbless.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
  private User user;
  private final static String FIRST_NAME = "First name";
  private final static int AGE = 20;
  private final static String JOB = "Google";
  private final static String ADDRESS = "Spain, Madrid";


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
  public void testGroupUsers() {
    User dima = new User("Dima", 21, "Apple", "France");
    User max = new User("Max", 20, "Uber", "Poland");
    User alex = new User("Alex", 21, "Netflix", "Usa");
    User petr = new User("Petr", 20, "Amazon", "Germany");
    User bryan = new User("Bryan", 19, "Netflix", "Usa");

    List<User> users = List.of(dima, max, alex, petr, bryan);

    Map<Integer, List<User>> expectedGroups = new HashMap<Integer, List<User>>();

    expectedGroups.put(19, List.of(bryan));
    expectedGroups.put(20, List.of(max, petr));
    expectedGroups.put(21, List.of(dima, alex));

    Map<Integer, List<User>> actualUsersAgeToUsersResult = User.groupUsers(users);

    assertEquals(expectedGroups, actualUsersAgeToUsersResult);
  }
}
