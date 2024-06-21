package faang.school.godbless.Task_Activity_Analysis;

import lombok.Getter;

@Getter
public class UserAction {

    public enum ActionType {
        post, comment, like, share;
    }

    private int id;
    private String name;
    private ActionType actionType;
    private String actionDate;
    private String content;


    public UserAction(int id, String name, ActionType actionType, String actionDate, String content) {
        if (id < 0 || name.isBlank() || actionDate.isBlank() || content.isBlank()) {
            throw new IllegalArgumentException("invalid arg(s)");
        } else {
            this.id = id;
            this.name = name;
            this.actionType = actionType;
            this.actionDate = actionDate;
            this.content = content;
        }
    }

    @Override
    public String toString() {
        return "(" + name + ", " + actionType + ")";
    }

    public static void main(String[] args) {

        UserAction testAction = new UserAction(1, "test", ActionType.post,
                "01.01.01.", "test");
        System.out.println(testAction);

    }

}
