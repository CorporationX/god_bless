import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.user.group.User.groupUsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.user.group.User;

public class UserGroupingTest {

  private static final String DATA_FILE = "src/test/resources/users.json";
  static List<User> users = new ArrayList<>();

  @BeforeEach
  void setUp() throws IOException {
    getUserList();
  }

  @Test
  @DisplayName("Group users by age")
  void testUserGrouping() {
    Map<Integer, List<User>> groupedUsers = groupUsers(users);
    int ageGroups = 3;
    assertEquals(ageGroups, groupedUsers.size());
  }

  void getUserList() throws IOException {
    File file = new File(DATA_FILE);
    ObjectMapper objectMapper = new ObjectMapper();
    users = objectMapper.readValue(file, new TypeReference<>() {
    });
  }

}
