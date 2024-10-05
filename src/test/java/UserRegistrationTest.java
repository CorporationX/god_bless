import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.user.registration.User;

public class UserRegistrationTest {

  @Test
  @DisplayName("invalid user name")
  void testInvalidName() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User("", 20, "Amazon", "New York");
    });
  }

  @Test
  @DisplayName("invalid user age")
  void testInvalidAge() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User("Alex", 15, "Amazon", "New York");
    });
  }

  @Test
  @DisplayName("invalid user workplace")
  void testInvalidWorkplace() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User("Alex", 20, "no place", "New York");
    });
  }

  @Test
  @DisplayName("invalid user address")
  void testInvalidAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User("Alex", 20, "Uber", "Washington");
    });
  }

  @Test
  @DisplayName("invalid user data")
  void testInvalidData() {
    assertThrows(IllegalArgumentException.class, () -> {
      new User("", 5, "some", "nowhere");
    });
  }

}
