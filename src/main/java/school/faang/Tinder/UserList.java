package school.faang.Tinder;

import java.util.ArrayList;
import java.util.List;

public class UserList {
  private final List<User> users = new ArrayList<>();

  public List<User> getOnlineUsers() {
    return users.stream().filter(User::isOnline).toList();
  }

  public void addUser(User user) {
    users.add(user);
  }

  public void removeUser(User user) {
    users.remove(user);
  }
}
