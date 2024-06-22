package faang.school.godbless.bjs2_12768;

import java.util.List;
import lombok.Getter;

@Getter
public class House {

  private String name;
  private int countAvailableRole;
  private List<String> availableRoles;

  public House(String name, List<String> availableRoles) {
    this.name = name;
    this.availableRoles = availableRoles;
    this.countAvailableRole = this.availableRoles.size();
  }

  public void addRole(String role) {
    countAvailableRole--;
    availableRoles.remove(role);
  }

  public void removeRole(String role) {
    countAvailableRole++;
    availableRoles.add(role);
    notifyAll();
  }

}
