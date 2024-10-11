package school.faang.analysisOfUserActivity.repositorys;

import school.faang.analysisOfUserActivity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
  private final List<User> users = new ArrayList<>();

  public Optional<User> findUserById(int id) {
    return users.stream().filter(user -> user.getId() == id).findFirst();
  }

  public void addUser(User user) {
    users.add(user);
  }
}
