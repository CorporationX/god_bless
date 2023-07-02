package faang.school.godbless;

import lombok.Data;

@Data
public class User {
    private String username;
    private boolean isOnline;
    public User(String username) {
        this.username = username;
        this.isOnline = false;
    }


}
