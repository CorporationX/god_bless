package faang.school.godbless.tinder;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
public class ChatManager {
    private final Queue<Chat> openChats = new LinkedList<>();

    public void startChat(User userSearchingChat) {
        Chat newCreatedChat = new Chat(this, userSearchingChat);

        synchronized (this) {
            openChats.add(newCreatedChat);
            System.out.println(userSearchingChat.getName() + " CREATED new chat");
            notifyAll();

            while (newCreatedChat.getSecondUser() == null) {
                System.out.println("Waiting until someone will connect");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        newCreatedChat.startConversation();

        while (!Thread.currentThread().isInterrupted()) {
            supportConversation(newCreatedChat);

            newCreatedChat.isItTimeToCloseConversation();
        }
    }

    public synchronized void waitForChat(User userSearchingOpenChat) {
        while (openChats.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Chat openChat = openChats.poll();
        openChat.setSecondUser(userSearchingOpenChat);
        System.out.println(userSearchingOpenChat.getName() + " JOINED to the open chat");
        notifyAll();
    }

    public void endChat() {
        Thread.currentThread().interrupt();
        System.out.println("Conversation closed");
    }

    private void supportConversation(Chat chat) {
        chat.deliverMessage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
