package faang.school.godbless.activity.analysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAction {

    private Long userId;
    private String userName;
    private String actionType;
    private LocalDate actionDate;
    private String content;

}
