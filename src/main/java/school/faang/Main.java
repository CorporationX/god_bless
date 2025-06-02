package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Users> usersList = new ArrayList<>(Arrays.asList(
                new Users("Дима", 21, "Польша", "Okopowa 7"),
                new Users("Руслан", 21, "Азейбарджан", "Petrokova 245"),
                new Users("Марк", 32, "России", "Пушкина 16"),
                new Users("Теодор", 65, "Турция", "Freds 23")
        ));
        Map<Integer, List<Users>> groupUserAge = Users.groupUsers(usersList);
    }

}
