package faang.school.godbless.fifth;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

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
        users.add(new User("Lena", 22, "Avon", "Moscow"));
        users.add(new User("Igor", 22, "Samsung", "N.Novgorod"));
        users.add(new User("Sasha", 13, "Apple", "Samara"));
        users.add(new User("Petr", 18, "Oracle", "London"));

        groupUsers(users);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> selectedUsers = new HashMap<>();
        for (User user : users) {
            if (!selectedUsers.containsKey(user.getAge())) {
                if (user.getAge() >= 18) {
                    selectedUsers.put(user.getAge(), new ArrayList<>(Arrays.asList(user)));
                }
            } else {selectedUsers.get(user.getAge()).add(user);}
        }
        System.out.println(selectedUsers.toString());
        return selectedUsers;
    }
}