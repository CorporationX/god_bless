package school.faang;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> userList = List.of(
                new User("Alex", 30, "Sberbank", "Moscow"),
                new User("Sergey", 27, "Alfa Bank", "Saint Petersburg"),
                new User("Alina", 27, "T-bank", "Moscow"),
                new User("Alex", 25, "VTB", "Saint Petersburg"),
                new User("Kseniya", 31, "VTB", "Samara"),
                new User("Kate", 35, "Sberbank", "Kazan"),
                new User("Irina", 45, "T-bank", "Yekaterinburg"),
                new User("Mary", 45, "Sberbank", "Челябинск"),
                new User("Pete", 27, "Alfa Bank", "Chelyabinsk")
        );

        var groups = User.groupUsers(userList);
        var keys = groups.keySet().stream().sorted(Integer::compareTo).toList();
        for (Integer key : keys) {
            for (User user : groups.get(key)) {
                System.out.println(user);
            }
        }

    }
}
