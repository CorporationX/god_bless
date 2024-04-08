package faang.school.godbless.fifth;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String gob;
    private String address;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vadim", 22, "Samsung", "St.Petersburg"));
        users.add(new User("Dima", 18, "Google", "Moscow"));
        users.add(new User("Lena", 17, "Avon", "Moscow"));
        users.add(new User("Igor", 12, "Samsung", "N.Novgorod"));
        users.add(new User("Sasha", 23, "Apple", "Samara"));
        users.add(new User("Petr", 26, "Oracle", "London"));

        groupUsers(users);
    }

    public static Map<Integer, User> groupUsers(List<User> users) {
        Map<Integer, User> selectedUsers = new HashMap<>();
        for (User user : users) {
            if (user.getAge() >= 18) {
                selectedUsers.put(user.getAge(), user);
            }
        }
        return selectedUsers;
    }
}