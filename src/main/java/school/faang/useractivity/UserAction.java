package school.faang.useractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate date;
    private String content;
}
