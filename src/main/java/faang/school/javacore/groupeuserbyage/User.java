package faang.school.javacore.groupeuserbyage;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ToString
@AllArgsConstructor
public class User {
    final String name;
    final int age;
    final String placeOfWork;
    final String address;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 22, "Wb", "RB, g.Grodno, ul.Limoja"));
        users.add(new User("Oleg", 28, "Wb", "RB, g.Gomel, ul.Soveckay"));
        users.add(new User("Max", 22, "Avito", "RB, g.Minsk, ul.Derjinskogo"));

        HashMap mapUsers = groupUsersOrAge(users);
        for (Object user : mapUsers.entrySet()) {
            System.out.println(user);
        }

    }

    private static HashMap groupUsersOrAge(List<User> listUsers) {
        HashMap<Integer, List> mapUsers = new HashMap<>();
        for (User user : listUsers) {
            mapUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return mapUsers;
    }
}
