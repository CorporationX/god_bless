package user.activity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static int idCount = 1;
    private final int userId;
    private final String userName;

    public User(@NonNull String userName) {
        this.userId = idCount++;
        this.userName = userName;
    }
}
