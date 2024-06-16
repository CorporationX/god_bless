package faang.school.godbless.streamapi.useractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserAction {
    private int userId;

    private String userName;

    private String actionType;

    private Date actionDate;

    private String content;
}