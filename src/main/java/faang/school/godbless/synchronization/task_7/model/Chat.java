package faang.school.godbless.synchronization.task_7.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Chat {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private static final int CHAT_SIZE = 2;
    private final Set<User> usersInChat = new HashSet<>(CHAT_SIZE);
    private final User firstUser;
    private final User secondUser;
    private final int chatId;

    public Chat(User firstUser, User secondUser) {
        this.chatId = ID_GENERATOR.incrementAndGet();
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        usersInChat.add(firstUser);
        usersInChat.add(secondUser);
    }

    public void deactivateChat() {
        firstUser.leaveTheChat(this.chatId);
        secondUser.leaveTheChat(this.chatId);
        System.out.println(firstUser.getName() + " и " + secondUser.getName() + " закончили общаться в чате " + this.chatId);
        usersInChat.clear();
    }
}