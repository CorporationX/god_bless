package faang.school.godbless.mattersOfTheheart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private UserChatStatus chatStatus;
}
