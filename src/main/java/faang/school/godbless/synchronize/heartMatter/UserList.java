package faang.school.godbless.synchronize.heartMatter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserList {
    List<User> users;
    List<User> wantToChatUsers = new ArrayList<>();

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getWantToChatUsers() {
        for (User user : users) {
            if (user.isOnline() && user.isWantToChat()) {
                wantToChatUsers.add(user);
            }
        }

        return wantToChatUsers;
    }
}
