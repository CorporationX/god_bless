package faang.school.godbless.ActiveUsersCheck;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAction implements TopicProvider {
    private String userId;
    private String userName;
    private String actionType;
    private String actionDate;
    private String content;

    public UserAction(String userId, String userName, String actionType, String actionDate, String content) {
        this.userId = userId;
        this.userName = userName;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
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

    @Override
    public List<String> getTopics() {
        return Arrays.asList(content.split("#"));
    }

    public static Map<String, Double> calculateActionPercentages(List<UserAction> actions) {
        int totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}