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
    private EnumActionType actionType;
    private LocalDate actionDate;
    private String content;

    public String getActionType() {
        switch (actionType){
            case POST: return "post";
            case COMMENT: return "comment";
            case LIKE: return "like";
            case SHARE:return "share";
            default: return "Enum не определен";
        }
    }
}
