package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private ActionType action;
    private Date actionDate;
    private String content;
}
