package activityAnalyzer;

import lombok.Data;

import java.util.List;

@Data
public class UserAction {
    private static final List<String> VALID_ACTION_TYPE = List.of("post", "comment", "like", "share");
    private static int counterId = 1;
    private int id;
    private String actionType;
    private String content;

    public UserAction(String actionType, String content) {
        this.id = counterId;
        this.actionType = actionType;
        this.content = content;
        counterId++;
    }
}
