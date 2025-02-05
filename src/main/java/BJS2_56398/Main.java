package BJS2_56398;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User sasha = new User("Sasha", 25, "Adobe", "Moscow");
        User zhenya = new User("Zhenya", 45, "PicsArt", "Yerevan");
        User gor = new User("Gor", 25, "Tumo", "Yerevan");
        User ani = new User("Ani", 22, "PinUp", "Tbilisi");

        users.add(sasha);
        users.add(zhenya);
        users.add(gor);
        users.add(ani);

        System.out.println(User.groupUsers(users));
    }
}
