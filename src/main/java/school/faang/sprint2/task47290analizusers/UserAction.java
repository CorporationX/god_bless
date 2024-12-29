package school.faang.sprint2.task47290analizusers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private Integer id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
