package school.faang.task_47208;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public String getActionType() {
        return switch (actionType) {
          case POST -> "post";
          case COMMENT -> "comment";
          case LIKE -> "like";
          case SHARE -> "share";
          default -> "Enum не определен";
        };
    }
}
