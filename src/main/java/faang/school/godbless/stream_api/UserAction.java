package faang.school.godbless.stream_api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private String content;
    private LocalDate actionDate;
}
