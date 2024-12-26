package school.faang.task_49143;

import lombok.Data;

@Data
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;

    public User(String name) {
        this.name = name;
        this.isOnline = false;
        this.isLookingForChat = false;
    }
}
