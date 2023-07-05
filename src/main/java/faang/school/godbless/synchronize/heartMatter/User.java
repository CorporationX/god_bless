package faang.school.godbless.synchronize.heartMatter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean wantToChat;
}
