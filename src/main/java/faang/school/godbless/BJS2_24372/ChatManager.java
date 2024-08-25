package faang.school.godbless.BJS2_24372;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ChatManager {
    private static final Logger log = LoggerFactory.getLogger(ChatManager.class);
    private final List<Chat> chats = new ArrayList<>();
    private final UserList userList;

    public synchronized void startChat(User user) {
        if (isSuitablePartner(user)) {
            User partner = userList.getUserWantsChattingExceptUser(user);
            Chat chat = new Chat(user, partner);
            user.setStatus(Status.CHATTING);
            partner.setStatus(Status.CHATTING);
            chat.chatting();
            chats.add(chat);
        } else {
            if (user.getStatus() == Status.WANTS_CHATTING) {
                waitForChat(user);
            }
        }
    }

    private synchronized void waitForChat(User user) {
        while (!isSuitablePartner(user)) {
            try {
                System.out.println(user.getName() + " waiting for chat");
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        startChat(user);
        notifyAll();
    }

    public synchronized void endChat(User user) {
        Chat chat = getChat(user);
        if (chat == null) {
            return;
        }
        System.out.println(chat.getUser().getName() + " has ended chat with " + chat.getPartner().getName());
        chats.remove(chat);
        chat.getUser().setStatus(Status.OFFLINE);
        chat.getPartner().setStatus(Status.OFFLINE);
        notifyAll();
    }

    private synchronized Chat getChat(User user) {
        return chats.stream()
                .filter(chat -> chat.getUser().equals(user) || chat.getPartner().equals(user))
                .findAny().orElse(null);
    }

    private synchronized boolean isSuitablePartner(User user) {
        return userList.getUserWantsChattingExceptUser(user) != null;
    }
}
