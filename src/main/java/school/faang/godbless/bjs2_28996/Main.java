package school.faang.godbless.bjs2_28996;

import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    List<User> users = List.of(
        new User("Homelander", 32, "Google", "London"),
        new User("Geralt of Rivia", 94, "Kaer Morhen, witcher", "12 Witcher PL, Rivia"),
        new User("Dexter Morgan", 32, "Miami Police Department, Forensics Specialist",
            "Miami, Florida(FL), 33162")
    );
    Map<Integer, List<User>> mappedUsers = User.groupUsers(users);
    System.out.println(mappedUsers);
  }
}
