package BJS218489;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User mathew = new User("Mathew", 21, "student", "Segezha");
        User egor = new User("Egor", 18, "student", "Petrozavodsk");
        User yarik = new User("Yarik", 16, "none", "Petrozavodsk");
        List<User> list = List.of(mathew, egor, yarik);
        System.out.println("Перебор ключ значения:" + User.groupList(list));
    }
}
