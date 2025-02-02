package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       User pavel = new User("Павел", 31, "yandex", "Moscow");
        User semen = new User("Семен", 12, "yandex", "Orlov");
        User anton = new User("Антон", 75, "yandex", "Krasnodar");
        User ivan = new User("Иван", 12, "yandex", "Adler");
        User nikolai = new User("Николай", 57, "yandex", "Moscow");
        List<User> users = new ArrayList<>();
        users.add(pavel);
        users.add(semen);
        users.add(anton);
        users.add(ivan);
        users.add(nikolai);

        System.out.println(User.groupUsers(users));


    }
}
