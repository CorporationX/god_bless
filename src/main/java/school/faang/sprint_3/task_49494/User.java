package school.faang.sprint_3.task_49494;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private final String name;
    private boolean isOnline = true;
    private boolean isLookingForChat = true;
}