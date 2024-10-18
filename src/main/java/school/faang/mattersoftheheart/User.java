package school.faang.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}