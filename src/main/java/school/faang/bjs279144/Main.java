package school.faang.bjs279144;


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> usersList;
        usersList = List.of(
                new User("Дима", 21, "Польша", "Okopowa 7"),
                new User("Руслан", 21, "Азейбарджан", "Petrokova 245"),
                new User("Марк", 32, "России", "Пушкина 16"),
                new User("Теодор", 65, "Турция", "Freds 23")
        );
        Map<Integer, List<User>> groupUserAge = User.groupUsers(usersList);
        groupUserAge.forEach((age, users) -> {
            System.out.println("Возраст " + age + ": ");
            users.forEach(System.out::println);
        });

    }

}
