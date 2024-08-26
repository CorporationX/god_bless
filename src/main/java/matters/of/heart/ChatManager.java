package matters.of.heart;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class ChatManager {
    @Setter
    private boolean isActive = true;
    private final UserList userList;
    public final List<Chat> chats = new ArrayList<>();

    ChatManager(UserList userList) {
        this.userList = userList;
    }

    public void startChat(User user) throws InterruptedException {
        synchronized (this.userList.getLock()) {
            while (this.isActive) {
                Optional<User> opponent = this.userList.getUserForChat(user);

                if (opponent.isEmpty()) {
                    this.waitForChat(user);
                    this.userList.getLock().wait();
                }

                Chat chat = new Chat(user, opponent.get());

                this.userList.removeUserInWaitList(user);
                this.userList.removeUserInWaitList(opponent.get());

                user.setActiveChat(chat);
                opponent.get().setActiveChat(chat);

                this.chats.add(chat);

                System.out.printf(
                    ">Пользователь %s начал чат с %s\n",
                    chat.getUser1().getName(),
                    chat.getUser2().getName()
                );
            }
        }
    }

    public void waitForChat(User user) {
        synchronized (this.userList.getLock()) {
            if (user.getActiveChat().isEmpty()) {
                this.userList.addUserToWaitList(user);
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (this.userList.getLock()) {
            System.out.printf(
                "-Завершается чат между пользователями %s и %s\n",
                chat.getUser1().getName(),
                chat.getUser2().getName()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            chat.getUser1().removeActiveChat();
            chat.getUser2().removeActiveChat();
            this.chats.remove(chat);

            this.waitForChat(chat.getUser1());
            this.waitForChat(chat.getUser2());
        }
    }
}
