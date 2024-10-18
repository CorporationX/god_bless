package school.faang.gameOfThrones;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class House {
  @Getter
  private final List<String> roles;
  private final Set<String> availableRoles;

  House(List<String> roles) {
    this.roles = roles;
    availableRoles = new HashSet<>(roles);
  }

  public void addAvailableRole(String role) {
    availableRoles.add(role);
    notifyAll();
  }

  public boolean giveAvailableRole(String role) {
    return availableRoles.remove(role);
  }
}
