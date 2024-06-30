package faang.school.godbless.BJS2_12881;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ChatManager {
    private ChatList chats;
    private UserList users;


    synchronized public void startChat(User user) throws InterruptedException {
        while (users.isWantsToChat()) {
            if (users.isWantsToChat()) {
                List<User> availableUsers = users.getWantsToChatUser(user);
                User secondUser = availableUsers.get(Rand.RAND.nextInt(availableUsers.size()));
                Chat chat = chats.addChat(user, secondUser);
                user.setChat(chat);
                secondUser.setChat(chat);
                System.out.println("Начался чат " + chat.getFirstUser().getName() + " и " + chat.getSecondUser().getName());
                Thread.sleep(1000);
                endChat(chat);
            } else {
                waitForChat();
            }
        }
    }

    private void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage() + " поток был прерван");
        }
    }

    private void endChat(Chat chat) {
        System.out.println("Чат " + chat.getFirstUser().getName() + " и " + chat.getSecondUser().getName() + " закончен");
        chat.getFirstUser().leaveChat();
        chat.getSecondUser().leaveChat();
        notifyAll();
    }
}
