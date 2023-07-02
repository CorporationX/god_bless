package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;

public class Chat {
  private User[] users = new User[2];
  private List<Message> messages = new ArrayList<>();
  private boolean isChatFullfilled = false;

  public Chat() {

  }

  public Chat(User user) {
    users[0] = user;
  }

  public Chat(User firstUser, User secondUser) {
    users[0] = firstUser;
    users[1] = secondUser;
    isChatFullfilled = true;
  }

  private void sendMessage(String userId, String message) {
    messages.add(new Message(userId, message));
  }

  public void editMessage(String userId, String newMessage) {
    // check that user id is owner of message
    // replace old one for new one
  }

  public void markMessageAsRead(String userId) {
    // if another user read, mark as read
  }

  public void addUser(User user) {
    if (!isChatFullfilled) {
      for (int i = 0; i < users.length; i++) {
        if (users[i] == null) {
          users[i] = user;
        }
      }
    }
  }

  public boolean isChatFullfilled() {
    return users[users.length - 1] == null;
  }

  public User getFirstUser() {
    return users[0];
  }

  public User getSecondUser() {
    return users[1];
  }
}
