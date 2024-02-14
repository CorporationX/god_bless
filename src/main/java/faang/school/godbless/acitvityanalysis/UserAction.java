package faang.school.godbless.acitvityanalysis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {

    private long id;
    private String name;
    private String actionType;
    private String content;
    private LocalDate actionDate;
}
