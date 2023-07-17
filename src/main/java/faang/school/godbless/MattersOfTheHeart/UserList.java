package faang.school.godbless.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserList {
    private List<User> userList;

    public void moveUsersToChat(User user1, User user2) {
        userList.remove(user1);
        userList.remove(user2);
    }

    public void moveUsersToList(Chat chat) {
        userList.add(chat.getUser1());
        userList.add(chat.getUser2());
    }

    public List<User> getOnlineUsers() {
        return userList.stream()
                .filter(User::isOnline)
                .collect(Collectors.toList());
    }
}
