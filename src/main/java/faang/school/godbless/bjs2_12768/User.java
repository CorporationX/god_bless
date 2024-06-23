package faang.school.godbless.bjs2_12768;

import java.util.Optional;

public class User {

  private static final String EMPTY_VALUE = "";
  private static final long DEFAULT_ROLE_TIME = 5000L;
  private static final int MIN_ROLE_QUANTITY = 0;
  private static final String PLAYER_PLAYS_ROLE = " %s Игрок \"%s\" отыгрывает роль \"%s\" в доме \"%s\"";
  private static final String PLAYER_EXPECTS_ROLE = " %s Игрок \"%s\" ожидает свободную роль для дома \"%s\"";
  private static final String PLAYER_GETS_ROLE = " %s Игрок \"%s\" получает роль \"%s\" в доме \"%s\"";
  private static final String PLAYER_RETURNS_ROLE = " %s Игрок \"%s\" освобождает роль \"%s\" и покидает дом \"%s\"";

  private String name;
  private House house;
  private String role;
  private String currentThread;

  public User(String name, House house) {
    this.name = name;
    this.house = house;
  }

  private void joinHouse() {
    synchronized (house) {
      while (house.getCountAvailableRole() == MIN_ROLE_QUANTITY) {
        try {
          System.out.println(
              String.format(PLAYER_EXPECTS_ROLE, currentThread, name, house.getName()));
          house.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      role = getRandomRole();
      house.addRole(role);
      System.out.println(String.format(PLAYER_GETS_ROLE, currentThread, name, role, house.getName()));
    }
  }

  private void leaveHouse() {
    synchronized (house) {
      System.out.println(
          String.format(PLAYER_RETURNS_ROLE, currentThread, name, role, house.getName()));
      house.removeRole(role);
    }
  }

  public void playRole() {
    this.currentThread = Thread.currentThread().getName();
    joinHouse();
    try {
      System.out.println(
          String.format(PLAYER_PLAYS_ROLE, currentThread, name, role, house.getName()));
      Thread.sleep(DEFAULT_ROLE_TIME);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    leaveHouse();
  }

  private String getRandomRole() {
    return Optional.ofNullable(house.getAvailableRoles())
        .map(Utils::getRandomValueFromList)
        .orElse(EMPTY_VALUE);
  }

}
