package faang.school.godbless.BJS210258;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private Actions actionType;
    private LocalDate actionDate;
    private String content;
}
