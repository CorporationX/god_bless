package faang.school.godbless.r_edzie.streams.user_activity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private final LocalDate actionDate = LocalDate.now();
    private String content;
}
