package faang.school.godbless.social_media;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private String content;
}
