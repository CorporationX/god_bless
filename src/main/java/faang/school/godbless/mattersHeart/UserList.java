package faang.school.godbless.mattersHeart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList {
    private final List<User> users;

    public UserList() {
        this.users = new ArrayList<>();
    }
}
