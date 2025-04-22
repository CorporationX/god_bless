package school.faang.bjs270881;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class UserAction  {
    private int id;
    private String name;
    private ActionType action;
    private LocalDate actionDate;
    private String content;
}
