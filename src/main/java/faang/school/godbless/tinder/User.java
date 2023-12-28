package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private boolean isOnline;
    private boolean waitChat;

}
