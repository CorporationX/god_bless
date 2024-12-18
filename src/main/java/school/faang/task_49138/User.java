package school.faang.task_49138;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
