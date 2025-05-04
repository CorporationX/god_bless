package school.faang.stream3.mattersoftheheart;

import lombok.Data;

@Data
public class User {
    private final String name;
    private boolean isOnline = false;
    private boolean isLookingForChat = false;

    private Chat chat;
}
