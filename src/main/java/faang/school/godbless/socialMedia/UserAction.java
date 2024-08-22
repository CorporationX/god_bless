package faang.school.godbless.socialMedia;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private final LocalDate  actionDate;
    private String content;

}
