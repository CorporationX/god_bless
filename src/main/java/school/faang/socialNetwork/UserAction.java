package school.faang.socialNetwork;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class UserAction {
    private Integer id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
