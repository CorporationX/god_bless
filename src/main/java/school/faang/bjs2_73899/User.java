package school.faang.bjs2_73899;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private boolean isInChat;
}
