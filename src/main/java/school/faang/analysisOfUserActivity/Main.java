package school.faang.analysisOfUserActivity;

import school.faang.analysisOfUserActivity.repositorys.ActionsRepository;
import school.faang.analysisOfUserActivity.repositorys.UserRepository;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    UserRepository userRepository = new UserRepository();
    ActionsRepository actionsRepository = new ActionsRepository();

    userRepository.addUser(new User(1, "Alice", "@yandex.ru"));
    userRepository.addUser(new User(2, "Bob", "@icloud.com"));
    userRepository.addUser(new User(3, "Charlie", "@gmail.com"));
    userRepository.addUser(new User(4, "Dave", "@yandex.ru"));
    userRepository.addUser(new User(5, "Eve", "@icloud.com"));

    List<UserAction> actions = actionsRepository.getAllActions();

    System.out.println(UserActionAnalyzer.topActiveUsers(actions, 10, userRepository));
    System.out.println(UserActionAnalyzer.topPopularHashtags(actions, 5));
    System.out.println(UserActionAnalyzer.topCommentersLastMonth(actions, 3, userRepository));
    System.out.println(UserActionAnalyzer.actionTypePercentages(actions));
  }
}
