package faang.school.godbless.BJS2_18460;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Denis", 39, "Kazan", "Company1");
        User user2 = new User("Sergey", 40, "Kazan", "Company1");
        User user3 = new User("Ivan", 39, "Moscow", "Company2");
        User user4 = new User("Maria", 20, "Saint Petersburg", "Company3");
        User user6 = new User("Vitaliy", 25, "Moscow", "Company4");
        User user5 = new User("Dmitry", 39, "Saing Petersburg", "Company3");
        User user7 = new User("Leonid", 25, "Nignekamsk", "Company5");
        User user8 = new User("Svetlana", 22, "Samara", "Company1");
//       User user9 = new User("Ghost", -5, "Samara", "Company1");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user6);
        users.add(user5);
        users.add(user7);
        users.add(user8);

        Map<Integer, List<User>> map = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " age group:");
            entry.getValue().forEach(s-> System.out.println(s.getAge()+" - "+s.getName()));
            System.out.println("-----------------");
        }
    }
}
