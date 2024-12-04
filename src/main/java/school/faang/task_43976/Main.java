package school.faang.task_43976;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(new User("Ivan", 19, "Yandex",
                "123 Red Square, Moscow, 101000, Russia"));
        listOfUsers.add(new User("Dmitry", 38, "Sber",
                "45 Nevsky Prospekt, Saint Petersburg, 191011, Russia"));
        listOfUsers.add(new User("Alex", 25, "Uber",
                "22 Komsomolskaya Street, Kazan, 420012, Russia"));
        listOfUsers.add(new User("Nick", 33, "VTB",
                "78 Tverskaya Street, Moscow, 125009, Russia"));
        listOfUsers.add(new User("Jon", 19, "Creative Call Project",
                "101 Pushkin Street, Nizhny Novgorod, 603000, Russia"));
        listOfUsers.add(new User("Sergey", 38, "Amazon",
                "56 Sovetskaya Street, Novosibirsk, 630000, Russia"));

        Map<Integer, List<User>> gropedUsers = User.groupUsers(listOfUsers);

        for (Map.Entry<Integer, List<User>> entry : gropedUsers.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("\t" + user);
            }
        }
    }
}
