package faang.school.godbless.user;

import java.time.LocalDateTime;

public class UserAction {
  private String userId;
  private String userName;
  private ActionType actionType;
  private LocalDateTime actionDate;
  private String content;

  public UserAction(String userId, String userName, ActionType actionType, LocalDateTime actionDate, String content) {
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

  public LocalDateTime getActionDate() {
    return actionDate;
  }
}
