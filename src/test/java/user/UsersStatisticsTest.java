package user;

import faang.school.godbless.user.ActionType;
import faang.school.godbless.user.UserAction;
import faang.school.godbless.user.UsersStatistics;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersStatisticsTest {
  private List<UserAction> userActions = List.of(
      new UserAction("101", "test 1", ActionType.COMMENT, new Date(), "#comment #test 1"),
      new UserAction("102", "test 2", ActionType.LIKE, new Date(), "like test 1"),
      new UserAction("102", "test 1", ActionType.COMMENT, new Date(), "#comment #test 2"),
      new UserAction("103", "test 3", ActionType.SHARE, new Date(), "share test 1"),
      new UserAction("101", "test 2", ActionType.LIKE, new Date(), "Like 21"),
      new UserAction("104", "test 4", ActionType.LIKE, new Date(), "#Like 1"),
      new UserAction("102", "test 2", ActionType.COMMENT, new Date(), "#comment 1"),
      new UserAction("105", "test 5", ActionType.SHARE, new Date(), "Share 1"),
      new UserAction("104", "test 4", ActionType.SHARE, new Date(), "Share 1")
  );

  UsersStatistics usersStatistics = new UsersStatistics(userActions);
  @Test
  public void getMostActiveUsersTest() {
    assertEquals(List.of("102", "101", "104"), usersStatistics.getMostActiveUsers(3));
  }

  @Test
  public void getPopularTopicsTest() {
    assertEquals(List.of("#comment", "#test"), usersStatistics.getPopularTopics(2));
  }
}
