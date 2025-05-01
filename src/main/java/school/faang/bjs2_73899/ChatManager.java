package school.faang.bjs2_73899;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ChatManager {
    private final List<Chat> chats = new ArrayList<>();
    private final UserList users;

    public synchronized void startChat(User user) {
        while(users.getUsersReadyForChatFor(user).isEmpty()) {
            try {
                log.info("current thread {}." ,Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("Thread was interrupted in WAITFORCHAT. {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        User partner = users.getUsersReadyForChatFor(user).get(0);
        chats.add(new Chat(user, partner));
        user.setInChat(true);
        partner.setInChat(true);
        log.info("Chat started between {} and {}", user.getName(), partner.getName());
    }

    public void waitForChat() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Thread was interrupted in WAITFORCHAT. {}", e.getCause());
            Thread.currentThread().interrupt();
        }
    }

    public void endChat(User user) {
        if (!user.isInChat()) {
            log.info("You are not in the chat. Please enter a chat first.");
            return;
        }

        Chat chat = chats.stream()
            .filter(c -> c.getUser1().equals(user) || c.getUser2().equals(user))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Chat not found."));

        chat.getUser1().setInChat(false);
        chat.getUser2().setInChat(false);
        chats.remove(chat);
        log.info("Chat ended between {} and {}", chat.getUser1().getName(), chat.getUser2().getName());
    }
}
