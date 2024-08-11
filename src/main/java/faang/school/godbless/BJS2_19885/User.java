package faang.school.godbless.BJS2_19885;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;

    public static void addUser(User user) {
        Main.queriesByUser.putIfAbsent(user, new ArrayList<>());
    }

    public static void removeUser(User user) {
        Main.queriesByUser.remove(user);
    }
}
