package faang.school.godbless.BJS2_24444;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Setter
@Getter
public class ChatManager {
    private final BlockingQueue<User> waitingUsers = new LinkedBlockingQueue<>();
    private final List<Chat> chats = new ArrayList<>();

    public void startChat(User user) {
        if (user.isOffline()) {
            System.out.println(user.getName() + " оффлайн и не может общаться.");
            return;
        }
        if (!user.isWantTalk()) {
            System.out.println(user.getName() + " не хочет общаться.");
            return;
        }
        System.out.println(user.getName() + " хочет начать чат.");

        synchronized (chats) {
            User otherUser = waitingUsers.poll();

            if (otherUser == null) {
                System.out.println(user.getName() + " ждет, пока кто-то присоединится к чату...");
                waitingUsers.offer(user);
                waitForChat(user);
            } else {
                Chat chat = new Chat(user, otherUser);
                chats.add(chat);
                chats.notifyAll();
                chat.doChat(user, "Привет, я " + user.getName() + "!");
                chat.doChat(otherUser, "Привет, я " + otherUser.getName() + "!");
                endChat(chat);
            }
        }
    }

    private void waitForChat(User user) {
        synchronized (chats) {
            while (chats.stream().noneMatch(chat ->
                    chat.getFirstUser().equals(user) || chat.getSecondUser().equals(user))) {
                try {
                    System.out.println(user.getName() + " ждет чата...");
                    chats.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (chats) {
            chats.remove(chat);
            System.out.println("Чат между " + chat.getFirstUser().getName() +
                    " и " + chat.getSecondUser().getName() + " завершен.");
            chats.notifyAll();
        }
    }
}
