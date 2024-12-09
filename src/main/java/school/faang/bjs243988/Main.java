package school.faang.bjs243988;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        User parvin = new User("Parvin", 33, "Azerconnect LLC", "Baku");
        User murad = new User("Murad", 33, "Azerconnect LLC", "Baku");
        User ershad = new User("Ershad", 24, "Uni Bank", "Baku");
        User narmin = new User("Narmin", 30, "Always Smile", "Antalya");
        User dima = new User("Dima", 24, "Tinkoff", "Moscow");

        List<User> users = List.of(parvin, murad, ershad, narmin, dima);
        System.out.println(User.groupUsers(users));

    }

}
