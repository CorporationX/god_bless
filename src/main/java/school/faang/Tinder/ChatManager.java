package school.faang.Tinder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
  @Getter
  private final List<Chat> chats = new ArrayList<>();
  private final List<Chat> waitingChats = new ArrayList<>();

  public synchronized void startChat(User user) {
    Chat chat = new Chat();
    chat.setFirstUserId(user.getId());

    waitingChats.add(chat);
    System.out.printf("создан новый чат пользователем %s\n", user.getId());
    notify();
  }

  public synchronized void waitForChat(User user) {
    if (waitingChats.isEmpty()) {
      user.setLookingForChat(true);
      System.out.printf("пользователь %s ждет присоеденения к чату\n", user.getId());

      try {
        wait();
      } catch (InterruptedException e) {
        throw new IllegalStateException(e.getMessage(), e);
      }
    }

    Chat chat = waitingChats.remove(waitingChats.size() - 1);
    chat.setSecondUserId(user.getId());
    user.setLookingForChat(false);

    chats.add(chat);

    System.out.printf("пользователь %s присоеденился к чату с пользователем %s\n", user.getId(), chat.getFirstUserId());
  }


  public synchronized void endChat(Chat chat) {
    chats.remove(chat);

    System.out.printf("чат %s с %s закончен\n", chat.getFirstUserId(), chat.getSecondUserId());
  }
}
