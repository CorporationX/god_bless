package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        List<User> users = List.of(
        new User("Ivan", 48, "Google", "682085, Moscow, ul.Novaja, 4-55"),
        new User("Sidor", 48, "Facebook", "682085, Moscow, ul.Novaja, 58-179"),
        new User("Petr", 64, "Amazon", "300205, Samara, ul.Staraja, 6-99"),
        new User("Anna", 42, "Microsoft", "890225, Voronez, ul.Novaja, 1-77"),
        new User("Vera", 31, "EPAM", "682085, Kursk, ul.Gagarina, 4-147"),
        new User("Ira", 20, "PandaDok", "245883, Bransk, ul.Sverdlova, 66-527"));

        Map<Integer, List<User>> mapGroup = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : mapGroup.entrySet()) {
            System.out.println("age " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}