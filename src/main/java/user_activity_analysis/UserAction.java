package user_activity_analysis;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserAction that = (UserAction) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(actionType, that.actionType) && Objects.equals(actionDate, that.actionDate) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actionType, actionDate, content);
    }

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
