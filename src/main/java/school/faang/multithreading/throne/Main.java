package school.faang.multithreading.throne;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) throws InterruptedException {
    House house = new House("STARK");
    List<Role> roles = List.of(
        new Role("Knight"),
        new Role("King"),
        new Role("Mage"));
    house.setRoles(roles);
    house.setAvailableRoles(roles.size());

    List<User> users = List.of(
        new User("Alex"),
        new User("Boris"),
        new User("Carl"),
        new User("Dmitry"),
        new User("Elvis"));

    List<Thread> threads = new ArrayList<>();

    int timeInHouseSec = 0;
    for (User user : users) {
      int finalTimeInHouseMilliSec = ++timeInHouseSec * 1000;
      threads.add(new Thread(() -> {
        try {
          user.joinHouse(house);
          Thread.sleep(finalTimeInHouseMilliSec);
          user.leaveHouse();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }, user.getName()));
    }
    threads.forEach(Thread::start);

    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException | RuntimeException e) {
        log.error("Caught exception args: {}", args, e);
      }
    });
    users.forEach(System.out::println);
    printHouseRoles(house);
  }

  private static void printHouseRoles(House house) {
    for (Role role : house.getRoles()) {
      System.out.println(
          role.getName() + " is " + (role.isAvailable() ? "vacant" : "already assigned"));
    }
  }

}
