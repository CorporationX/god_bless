package school.faang.BJS235518;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
