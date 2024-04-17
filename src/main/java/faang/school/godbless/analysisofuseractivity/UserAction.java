package faang.school.godbless.analysisofuseractivity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {

    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        if (actionType.equals("post") || actionType.equals("comment") || actionType.equals("like") || actionType.equals("share")) {
            this.id = id;
            this.name = name;
            this.actionType = actionType;
            this.actionDate = actionDate;
            this.content = content;
        } else {
            throw new IllegalArgumentException("Invalid value in the field actionDate");
        }

    }
}
