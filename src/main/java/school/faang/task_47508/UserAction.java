package school.faang.task_47508;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {

    private final int id;

    private final String name;

    private final ActionType actionType;

    private final LocalDate actionDate;

    private final String content;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID: " + id + "\n");
        str.append("Name: " + name + "\n");
        str.append("ActionType: " + actionType + "\n");
        str.append("ActionDate: " + actionDate + "\n");
        str.append("Content: " + content + "\n");
        str.append("\n");
        return str.toString();
    }
}