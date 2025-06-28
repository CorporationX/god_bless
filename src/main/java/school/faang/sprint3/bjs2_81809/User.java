package school.faang.sprint3.bjs2_81809;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
