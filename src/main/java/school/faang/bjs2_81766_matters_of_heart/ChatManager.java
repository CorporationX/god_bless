package school.faang.bjs2_81766_matters_of_heart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RequiredArgsConstructor
public class ChatManager {
    private final UserList userList;

    public void waitForChat() {
        //Unclear from task why we need this method
    }

    public Chat startChat(User user) {
        synchronized (userList) {
            Optional<User> partner = userList.getRandomPartner(user);
            while (partner.isEmpty()) {
                try {
                    log.info("No partners found for user {}, waiting...", user.getName());
                    userList.wait();
                    partner = userList.getRandomPartner(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("Found partner for {} : {}", user.getName(), partner.get().getName());
            Chat chat = new Chat(user, partner.get());
            chat.begin();
            return chat;
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            chat.end();
            userList.notifyAll();
        }
    }

    public Chat createNewChat() {
        synchronized (userList) {
            log.info("Creating brand new chat!");
            AtomicReference<Chat> chat = new AtomicReference<>();
            Optional<User> willingUser = userList.getOnlineUsersForChat().stream().findFirst();
            willingUser.ifPresentOrElse(
                    wu -> {
                        wu.setLookingForChat(false);
                        chat.set(this.startChat(wu));
                    },
                    () -> log.info("No new willing users, no chat created.")
            );
            return chat.get();
        }
    }
}

