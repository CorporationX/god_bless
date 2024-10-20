package school.faang.multithreading.throne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String name;
  private House house;
  private Role role;

  public static final House OUT_OF_HOUSE = new House("OUT OF HOUSE");
  public static final Role NO_ROLE = new Role("NO ROLE");

  public User(String name) {
    this.name = name;
    house = OUT_OF_HOUSE;
    role = NO_ROLE;
  }

  public void joinHouse(House house) throws InterruptedException {
    synchronized (house) {
      if (house.getAvailableRoles() == 0) {
        System.out.println(name + " wait at entrance to " + house);
        house.wait();
      }
      this.house = house;
      this.role = house.getFirstAvailableRole();
      role.setAvailable(false);
      System.out.println(name + " join : " + house);
      house.addRole();
    }
  }

  public void leaveHouse() {
    synchronized (house) {
      System.out.println(name + " leave " + house);
      role.setAvailable(true);
      house.removeRole();
      this.role = NO_ROLE;
      this.house = OUT_OF_HOUSE;
    }
  }

  @Override
  public String toString() {
    return name + " | " + role.getName() + ", " + house.getName();
  }

}
