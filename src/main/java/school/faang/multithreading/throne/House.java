package school.faang.multithreading.throne;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {

  private String name;
  private List<Role> roles = new ArrayList<>();
  private int availableRoles;

  public House(String name) {
    this.name = name;
  }

  public void addRole() {
    availableRoles--;
    System.out.println("=> [" + this + "] : - one role closed");
  }

  public synchronized void removeRole() {
    availableRoles++;
    System.out.println("=> [" + this + "] : + one role opened");
    notify();
  }

  public Role getFirstAvailableRole() {
    return roles.stream().filter(Role::isAvailable).findAny().orElse(User.NO_ROLE);
  }

  @Override
  public String toString() {
    return name + "(" + availableRoles + ")";
  }
}
