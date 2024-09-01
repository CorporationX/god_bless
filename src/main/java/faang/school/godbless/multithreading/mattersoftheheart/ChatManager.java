package faang.school.godbless.multithreading.mattersoftheheart;

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
            System.out.printf("> %s is offline%n", user.getName());

            return;
        }

        if (!user.isWantTalk()) {
            System.out.printf("> %s don't want to chat%n", user.getName());

            return;
        }

        System.out.printf("> %s want to start chat%n", user.getName());

        synchronized (chats) {
            User otherUser = waitingUsers.poll();

            if (otherUser == null) {
                System.out.printf("> %s is waiting to someone, who wants to chat%n", user.getName());

                waitingUsers.offer(user);

                waitForChat(user);
            } else {
                Chat chat = new Chat(user, otherUser);

                chats.add(chat);
                chats.notifyAll();

                chat.doChat(user, "hi, my name is " + user.getName() + "!");
                chat.doChat(otherUser, "hi, my name is " + otherUser.getName() + "!");

                endChat(chat);
            }
        }
    }

    private void waitForChat(User user) {
        synchronized (chats) {
            while (chats.stream().noneMatch(chat ->
                    chat.getFirstUser().equals(user) || chat.getSecondUser().equals(user))) {

                try {
                    System.out.printf("> %s wait for chat%n", user.getName());

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

            System.out.printf("> chat between %s and %s is closed%n",
                    chat.getFirstUser().getName(),
                    chat.getSecondUser().getName());

            chats.notifyAll();
        }
    }

}
