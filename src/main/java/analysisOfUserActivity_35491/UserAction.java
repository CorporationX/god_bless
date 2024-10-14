package analysisOfUserActivity_35491;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class UserAction {
    private final int id;
    private final String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
