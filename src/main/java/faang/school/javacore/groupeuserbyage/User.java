package faang.school.javacore.groupeuserbyage;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

@ToString
@AllArgsConstructor
public class User {

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public static void main(String[] args) {
        User alex = new User("Alex", 22, "Wb", "RB, g.Grodno, ul.Limoja");
        User oleg = new User("Oleg", 28, "Wb", "RB, g.Gomel, ul.Soveckay");
        User max = new User("Max", 22, "Avito", "RB, g.Minsk, ul.Derjinskogo");

        List<User> users = new ArrayList<>(Arrays.asList(alex, oleg, max));

        printMapUser(groupUsersOrAge(users));

    }

    private static void printMapUser(HashMap<Integer, List> mapUsers) {
        if (mapUsers != null) {
            for (Map.Entry<Integer, List> user : mapUsers.entrySet()) {
                System.out.println(user);
            }
        }
    }

    private static HashMap<Integer, List> groupUsersOrAge(List<User> listUsers) {
        if (listUsers != null) {
            HashMap<Integer, List> mapUsers = new HashMap<>();
            for (User user : listUsers) {
                mapUsers.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
            }
            return mapUsers;
        }
        return null;
    }
}
