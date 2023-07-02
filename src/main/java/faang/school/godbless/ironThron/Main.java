package faang.school.godbless.ironThron;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    House house = new House("Вестерос");
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      users.add(new User("user" + i));
    }

    ExecutorService joinService = Executors.newFixedThreadPool(1);
    for (int i = 0; i < 25; i++) {
      Role role = getRole(i);
      User user = users.get(i);
      joinService.submit(() -> user.joinHouse(house, role));
    }

    try {
      joinService.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    System.out.println("Waiting");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ExecutorService leavingService = Executors.newFixedThreadPool(1);
    for (int i = 0; i < 10; i++) {
      User user = users.get(i);
      leavingService.submit(user::leaveHouse);
    }
    joinService.shutdown();

    leavingService.shutdown();
  }

  private static Role getRole(int i) {
    int candidateNumber = i % Role.values().length;

    Role role = Role.WIZARD;

    switch (candidateNumber) {
      case 1:
        role = Role.KNIGHT;
        break;
      case 2:
        role = Role.LORD;
        break;
      case 3:
        role = Role.WIZARD;
        break;
    }

    return role;
  }
}
