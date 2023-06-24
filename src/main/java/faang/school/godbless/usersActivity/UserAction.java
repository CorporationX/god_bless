package faang.school.godbless.usersActivity;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class UserAction {
    @NonNull
    private final int idUser;
    @NonNull
    private final String nameUser;
    @NonNull
    private final ActionType actionType;
    @NonNull
    private final Date actionDate;
    @NonNull
    private final String content;

}
