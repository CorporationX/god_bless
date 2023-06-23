package user;

import faang.school.godbless.user.ActionType;
import faang.school.godbless.user.UserAction;
import faang.school.godbless.user.UsersStatistics;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersStatisticsTest {
  private List<UserAction> userActions = List.of(
      new UserAction("101", "test 1", ActionType.COMMENT, LocalDateTime.now(), "#comment #test 1"),
      new UserAction("102", "test 2", ActionType.LIKE, LocalDateTime.now(), "like test 1"),
      new UserAction("102", "test 1", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "#comment #test 2"),
      new UserAction("103", "test 3", ActionType.SHARE, LocalDateTime.now(), "share test 1"),
      new UserAction("101", "test 2", ActionType.LIKE, LocalDateTime.now(), "Like 21"),
      new UserAction("104", "test 4", ActionType.LIKE, LocalDateTime.now(), "#Like 1"),
      new UserAction("102", "test 2", ActionType.COMMENT, LocalDateTime.now().minusDays(10), "#comment 1"),
      new UserAction("102", "test 2", ActionType.COMMENT, LocalDateTime.now().minusDays(5), "#comment 1"),
      new UserAction("105", "test 5", ActionType.SHARE, LocalDateTime.now(), "Share 1"),
      new UserAction("104", "test 4", ActionType.COMMENT, LocalDateTime.now(), "Comment 1"),
      new UserAction("104", "test 4", ActionType.COMMENT, LocalDateTime.now(), "Comment 2"),
      new UserAction("103", "test 4", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "Comment 2"),
      new UserAction("103", "test 4", ActionType.COMMENT, LocalDateTime.now().minusMonths(2), "Comment 2"),
      new UserAction("103", "test 4", ActionType.COMMENT, LocalDateTime.now().minusMonths(3), "Comment 2"),
      new UserAction("103", "test 4", ActionType.COMMENT, LocalDateTime.now().minusMonths(4), "Comment 2")
  );

  UsersStatistics usersStatistics = new UsersStatistics(userActions);
  @Test
  public void getMostActiveUsersTest() {
    assertEquals(List.of("103", "102", "104"), usersStatistics.getMostActiveUsers(3));
  }

  @Test
  public void getPopularTopicsTest() {
    assertEquals(List.of("#comment", "#test"), usersStatistics.getPopularTopics(2));
  }

  @Test
  public void getTopUsersTest() {
    assertEquals(List.of("102", "104", "101"), usersStatistics.getTopUsers(3));
  }

  @Test
  public void getActivityPercentageTest() {
    Map<ActionType, Float> expectedResult =  new HashMap<ActionType, Float>() {{
      put(ActionType.LIKE, 20.0F);
      put(ActionType.SHARE, 13.333333F);
      put(ActionType.COMMENT, 66.666664F);
    }};

    assertEquals(expectedResult, usersStatistics.getActivityPercentage());
  }
}
