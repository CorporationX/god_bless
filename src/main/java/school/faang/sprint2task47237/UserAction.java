package school.faang.sprint2task47237;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class UserAction {
    private long id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}