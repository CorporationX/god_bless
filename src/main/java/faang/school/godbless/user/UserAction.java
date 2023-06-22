package faang.school.godbless.user;

import java.util.Date;
import java.util.List;

public class UserAction {
  private String userId;
  private String userName;
  private ActionType actionType;
  private Date actionDate;
  private String content;

  public UserAction(String userId, String userName, ActionType actionType, Date actionDate, String content) {
    this.userId = userId;
    this.userName = userName;
    this.actionType = actionType;
    this.actionDate = actionDate;
    this.content = content;
  }

  public String getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public ActionType getActionType() {
    return actionType;
  }

  public String getContent() {
    return content;
  }
}
