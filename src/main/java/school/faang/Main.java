package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <User> listUser = new ArrayList<>();

        User mikhaill = new User("Mikhaill", 32, "Enginer", "Moscow");
        User alina = new User("Alina", 28, "Doctor", "St. Peterburg");
        User artem = new User("Artem", 45, "Architect", "Yekaterinburg");
        User elizaveta = new User("Elizaveta", 28, "Marketing", "Kazan");
        User dima = new User("Dima", 32, "Teacher", "Novosibirsk");

        listUser.add(mikhaill);
        listUser.add(alina);
        listUser.add(artem);
        listUser.add(elizaveta);
        listUser.add(dima);

        System.out.println(User.groupUsers(listUser));

    }
}
