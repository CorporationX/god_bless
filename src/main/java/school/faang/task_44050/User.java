package school.faang.task_44050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class User {

  private String name;
  private int age;
  private String workplace;
  private String address;

  public User(String name, int age, String workplace, String address) {
    this.name = name;
    this.age = age;
    this.workplace = workplace;
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + ", age=" + age + ", workplace='" + workplace + '\''
        + ", address='" + address + '\'' + '}';
  }

  public static Map<Integer, List<User>> groupUsers(List<User> users) {
    Map<Integer, List<User>> groupedUsers = new HashMap<>();
    for (User user : users) {
      if (!groupedUsers.containsKey(user.getAge())) {
        groupedUsers.put(user.getAge(), new ArrayList<>());
      }
      groupedUsers.get(user.getAge()).add(user);
    }
    return groupedUsers;
  }

  public static String formatGroupedUsersToPrettyView(Map<Integer, List<User>> groupedUsers) {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    int i = 0;
    for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
      sb.append("  ").append(entry.getKey()).append(": [\n");
      for (User user : entry.getValue()) {
        sb.append("    ").append(user.toString()).append(",\n");
      }
      if (!entry.getValue().isEmpty()) {
        sb.delete(sb.length() - 2, sb.length()); //Remove trailing ",\n"
      }
      sb.append("  ]");
      i++;
      if (i < groupedUsers.size()) {
        sb.append(",\n"); // Comma before newline only if not the last entry
      } else {
        sb.append("\n");
      }
    }
    sb.append("}\n");
    return sb.toString();
  }
}
