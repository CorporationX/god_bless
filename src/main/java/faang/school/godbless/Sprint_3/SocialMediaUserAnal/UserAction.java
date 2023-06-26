package faang.school.godbless.Sprint_3.SocialMediaUserAnal;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, LocalDateTime actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

}
