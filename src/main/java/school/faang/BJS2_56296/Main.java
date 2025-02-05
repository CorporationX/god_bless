package school.faang.BJS2_56296;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
      List<User> users = List.of(
                new User(21, "Ivan", 33,
                        new HashSet<>(Set.of("Чтение", "Футбол"))),
                new User(21, "Sergey", 33,
                        new HashSet<>(Set.of("Футбол"))),
                new User(21, "Sergey", 33,
                        new HashSet<>(Set.of("Бег", "Футбол"))),
                new User(21, "Sergey", 33,
                        new HashSet<>(Set.of("Чтение", "Футбол")))
        );
        Set<String> hobbies = new HashSet<>(List.of("Чтение", "Футбол"));
        Map<User, String> hobby = User.findHobbyLovers(users, hobbies);
        System.out.println(hobby);
    }
    }

