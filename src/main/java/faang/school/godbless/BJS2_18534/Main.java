package faang.school.godbless.BJS2_18534;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", 23, "Shop", "Yekaterinburg");
        User user2 = new User("Olga", 25, "Kitchen", "Moscow");
        User user3 = new User("Andrey", 23, "Cafe", "St.Petersburg");
        User user4 = new User("Sergey", 24, "Restaurant", "Chelyabinsk");
        User user5 = new User("Sasha", 25, "Barber shop", "Omsk");
        User user6 = new User("Oleg", 24, "Pharmacy", "Novosibirsk");
        User user7 = new User("Timur", 28, "Cinema", "Tomsk");
        User user8 = new User("Kirill", 27, "Shop", "Vladivostok");

        Map<Integer, List<User>> users = User.groupUsers(List.of(user1, user2, user3, user4, user5, user6, user7, user8));
        System.out.println("Найденные пользователи: " + users);
    }
}
