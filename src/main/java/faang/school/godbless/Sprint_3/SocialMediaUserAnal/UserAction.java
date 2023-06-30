package faang.school.godbless.Sprint_3.SocialMediaUserAnal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;
}
