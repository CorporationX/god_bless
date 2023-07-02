package faang.school.godbless.ironThron;

import java.util.HashMap;
import java.util.Map;

public class House {
  private String name;
  private final Map<Role, Integer> mapRoleToRoleCount = new HashMap<>(Map.of(Role.LORD,3, Role.KNIGHT, 3, Role.WIZARD, 3)) ;

  public boolean isRoleAvailable(Role role) {
    return mapRoleToRoleCount.get(role) != 0;
  }

  public House(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void removeRole(Role role) {
    System.out.println(mapRoleToRoleCount.get(role) + 1);
    mapRoleToRoleCount.put(role, mapRoleToRoleCount.get(role) + 1);
  }

  public void addRole(Role role) {
    if (mapRoleToRoleCount.get(role) == 0) {
      throw new Error("You exceeded amount of role: " + role);
    }

    mapRoleToRoleCount.put(role, mapRoleToRoleCount.get(role) - 1);
  }
}
