package school.faang.groupingbyage;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User alex = new User("Alex", 27, "Yandex", "Moscow");
        User ann = new User("Ann", 27, "Sberbank", "SPB");
        User artem = new User("Artem", 23, "VTB", "SPB");
        User yana = new User("Yana", 30, "Epam", "Moscow");
        User alexander = new User("Alexander", 30, "PITS", "Krasnodar");
        List<User> userList = List.of(alex, ann, artem, yana, alexander);

        Map<Integer, List<User>> userMap = User.groupUsers(userList);
        System.out.println(userMap);
    }
}
