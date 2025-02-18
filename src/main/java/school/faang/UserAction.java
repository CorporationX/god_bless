package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;
}