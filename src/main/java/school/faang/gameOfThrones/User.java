package school.faang.gameOfThrones;

import lombok.Getter;

@Getter
public class User {
  private final String name;
  private House house;
  private String role;

  User(String name) {
    this.name = name;
  }

  public void joinHouse(House house, String role) {
    synchronized (house) {
      boolean roleIsAvailable;

      do {
        roleIsAvailable = house.giveAvailableRole(role);
        if (!roleIsAvailable) {
          try {
            System.out.printf("пользователь %s ждёт присоединения к дому с ролью %s\n", name, role);
            house.wait();
          } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage(), e);
          }
        }
      } while (!roleIsAvailable);

      this.house = house;
      this.role = role;

      System.out.printf("пользователь %s присоединился к дому с ролью %s\n", name, role);
    }
  }

  public synchronized void leaveHouse() {
    synchronized (house) {
      if(house != null) {
        house.addAvailableRole(role);

        System.out.printf("пользователь %s вышел из дома и освободил роль %s\n", name, role);

        house = null;
        role = null;
      }
    }
  }
}
