package school.faang.sprint1.task_bjs244012;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User denis = new User("Denis", 40, "Sberbank", "Saint-Petersburg");
        User vera = new User("Vera", 37, "Gazprom", "Saint-Petersburg");
        User natasha = new User("Natasha", 38, "Lukoil", "Saint-Petersburg");
        User sasha = new User("Sasha", 12, "School", "Saint-Petersburg");
        User masha = new User("Masha", 12, "School", "Saint-Petersburg");

        List<User> users = List.of(denis, vera, natasha, sasha, masha);
        System.out.println(User.groupUsers(users));
    }

}
