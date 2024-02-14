package Analyze;

import java.time.LocalDate;

public class UserAction {
    private String userId;
    private String userName;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(String userId, String userName, String actionType, LocalDate actionDate, String content) {
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

    public String getActionType() {
        return actionType;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "UserAction{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", actionType='" + actionType + '\'' +
                ", actionDate=" + actionDate +
                ", content='" + content + '\'' +
                '}';
    }
}
