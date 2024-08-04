package faang.school.godbless.BJS2_18507;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of(
                new User("John Smith", 25, "Alpha LLC", "5 Lenin St."),
                new User("Emily Johnson", 27, "Beta Inc.", "17 Peace Ave."),
                new User("Michael Brown", 25, "Gamma Corp.", "23 Soviet St."),
                new User("Sarah Davis", 24, "Delta Ltd.", "10 Gagarin St."),
                new User("David Wilson", 35, "Epsilon LLC", "3 Pushkin St."),
                new User("Emma Moore", 34, "Zeta Inc.", "8 Komsomol St."),
                new User("Daniel Taylor", 25, "Eta Corp.", "12 Lermontov St."),
                new User("Sophia Anderson", 35, "Theta LLC", "6 Kutuzov St."),
                new User("James Thomas", 24, "Iota Ltd.", "9 Dostoevsky St."),
                new User("Olivia Martinez", 35, "Kappa Inc.", "15 Chekhov St.")
        ));

        Map<Integer, List<User>> usersGroupByAge = User.groupUserByAge(users);
        usersGroupByAge.forEach((age, group) -> {
            System.out.println(age);
            group.forEach(System.out::println);
        });
    }
}
