package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class UserList {
  private List<User> users = new ArrayList<>();

  public List<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public Stream<User> getOnlineUsers() {
    return users.stream()
        .filter((currentUser -> currentUser.isOnline() && currentUser.isWaitingForChat()));
  }
}
