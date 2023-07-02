package faang.school.godbless.ironThron;

public class User {
  private String name;
  private House house;
  private Role role;

  public User(String name) {
    this.name = name;
  }

  public synchronized void joinHouse(House house, Role role) {
    this.house = house;

    synchronized (house) {
      if (!house.isRoleAvailable(role)) {
        System.out.println("Waiting until role: " + role +  " will be available");
        try {
          house.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

      this.role = role;
      house.addRole(role);
      System.out.println("User has joined to house named " + house.getName() + " with role: " + role);
    }
  }

  public synchronized  void leaveHouse() {
    synchronized (house) {
      house.removeRole(role);
      System.out.println("User has successfully leaved from the house named " + house.getName() + "with role: " + role);
      house.notify();
    }
  }
}
