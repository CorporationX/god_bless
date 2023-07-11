package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
  private UserList userList;
  private List<Chat> chatList = new ArrayList<>();
  private Object lock = new Object();

  public ChatManager(UserList allUsers) {
    this.userList = allUsers;
  }

  private User getNextWaitingUser(String currentUserName) {
    return userList.getOnlineUsers()
        .filter((user -> user.isWaitingForChat() && !user.getName().equals(currentUserName)))
            .findFirst().orElse(null);
  }

  public void startChat(User user) {
    synchronized (lock) {
      Chat chat = new Chat(user);
      chatList.add(chat);
      user.setWaitingForChat(false);

      System.out.println("New chat with user " + user.getName());

      User waitingToStartChatUser = getNextWaitingUser(user.getName());

      if (waitingToStartChatUser == null) {
        try {
          System.out.println("Waiting for the second user...");
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

      System.out.println("User " + waitingToStartChatUser.getName() + " joined to chat");
      chat.addUser(waitingToStartChatUser);
      waitingToStartChatUser.setWaitingForChat(false);
    }
  }

  public void waitForChat(User user) {
    synchronized (lock) {
      Chat chatWithOneUser = chatList.stream().filter(chat ->
              chat.getFirstUser().getName().equals(user.getName()) || chat.getSecondUser().getName().equals(user.getName())
          ).findFirst().orElse(null);

      if (chatWithOneUser == null) {
        try {
          System.out.println(user + " are not in chat");
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public void endChat(Chat chat) {
    synchronized (lock) {
      chatList.remove(chat);
      lock.notifyAll();
    }
  }
}
