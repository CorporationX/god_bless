package school.faang.bjs_85532;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> lisrUsers = List.of(
                new User("Oleg", 45, "Google", "New_York"),
                new User("Arina", 22, "Salon", "Kazan"),
                new User("Masha", 45, "School", "Moscow"),
                new User("Misha", 21, "Garage", "Protvino"),
                new User("Alina", 22, "Shop", "Tver"),
                new User("Mufasa", 22, "Zoopark", "Madrid")
        );
        System.out.println(User.groupUsers(lisrUsers));
    }
}
