package faang.school.godbless.BJS2_24364;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ChatManager {
    private final List<Chat> chats = new ArrayList<>();
    private final UserList users;

    public void startChat(User user) {
        Optional<User> userTwoOptional = users.getOnlineUsers().stream()
                .filter(secondUser -> !secondUser.equals(user))
                .filter(User::isWantToChat)
                .findFirst();

        if (userTwoOptional.isPresent()) {
            User userTwo = userTwoOptional.get();
            userTwo.setWantToChat(false);
            user.setWantToChat(false);
            chats.add(new Chat(user, userTwo));
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Wait");
            }
        }
    }
}
