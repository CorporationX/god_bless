package CendalJoe_BJS2_44009;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        User resident1 = new User("Ivan", 17, "Press", "Odincovo");
        User resident2 = new User("Igor", 35, "Gazprom", "Kirov");
        User resident3 = new User("Sergey", 35, "Police", "Samara");
        User resident4 = new User("Ekaterina", 17, "student", "Kazan");
        User resident5 = new User("Olga", 18, "Sber", "Ufa");
        List<User> ListOfUsers = new ArrayList<>();
        ListOfUsers.add(resident1);
        ListOfUsers.add(resident2);
        ListOfUsers.add(resident3);
        ListOfUsers.add(resident4);
        ListOfUsers.add(resident5);
    }
}
