package faang.school.godbless.kxnvg.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class UserAction {

    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
