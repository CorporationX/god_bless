package faang.school.godbless.analise;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserAction {
    private final static List<String> VALID_ACTION_TYPE = List.of("post", "comment", "like", "share");
    private int id;
    private String name;
    private Map<String, List<String>> actionType;
    private String actionData;
    private String content;

    public UserAction(int id, String name, String actionData,
                      String content, Map<String, List<String>> actionType) {
        examinationDataApplyInConstructor(name, actionData, content, actionType);
        this.id = id;
        this.name = name;
        this.actionData = actionData;
        this.content = content;
        this.actionType = actionType;
    }

    private void examinationDataApplyInConstructor(String name, String actionData,
                                                   String content, Map<String, List<String>> actionType) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "UserActon class in constructor apply name non-existent");
        }
        if (actionData == null) {
            throw new IllegalArgumentException(
                    "UserActon class in constructor apply actionDate non-existent");
        }
        if (content == null) {
            throw new IllegalArgumentException(
                    "UserActon class in constructor apply content non-existent");
        }
        if (actionType.isEmpty() || actionType == null) {
            throw new IllegalArgumentException(
                    "UserActon class in constructor apply Map is empty or non-existent");
        }
        if (actionType.keySet().stream().anyMatch(key -> !VALID_ACTION_TYPE.contains(key))) {
            throw new IllegalArgumentException(
                    "UserActon class in constructor apply Map have invalid key");
        }
    }
}
