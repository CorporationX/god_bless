package school.faang.godbless.bjs2_31494;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void testFindHobbyLovers() {
    User user1 = new User(1, "Vasya", 25, Set.of("Basketball", "Hockey", "Gaming"));
    User user2 = new User(2, "Petya", 19, Set.of("Basketball", "Skydiving", "Gaming"));
    User user3 = new User(3, "Masha", 53, Set.of("Rock Climbing", "Cooking"));
    User user4 = new User(4, "Vika", 10, Set.of("Painting", "Hunting"));
    Set<String> activitiesSet = Set.of("Rock Climbing", "Skydiving", "Basketball");
    List<User> usersList = List.of(user1, user2, user3, user4);

    Map<User, String> methodResult = User.findHobbyLovers(usersList, activitiesSet);

    for (User user : usersList) {
      checkUserMapping(methodResult, activitiesSet, user);
    }
  }

  private void checkUserMapping(Map<User, String> methodResult, Set<String> activitiesSet,
      User user) {
    if (activitiesSet.stream().anyMatch(user.getActivities()::contains)) {
      assertTrue(methodResult.containsKey(user)
          && activitiesSet.contains(methodResult.get(user))
          && user.getActivities().contains(methodResult.get(user))
      );
    } else {
      assertFalse(methodResult.containsKey(user));
    }
  }
}