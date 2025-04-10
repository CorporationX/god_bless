package school.faang.bjs2_68310.user_grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .id(123).name("Alex").age(30).placeOfWork("ABC Company").address("Lenin Street").build());
        users.add(User.builder()
                .id(245).name("Max").age(27).placeOfWork("QWERTY Company").address("Kirov Street").build());
        users.add(User.builder()
                .id(532).name("Pavel").age(30).placeOfWork("Auto Company").address("Lenin Street").build());
        users.add(User.builder()
                .id(111).name("Maria").age(30).placeOfWork("Red Company").address("Moscow Street").build());
        users.add(User.builder()
                .id(213).name("Elena").age(22).placeOfWork("White Company").address("Plekhanov Street").build());
        users.add(User.builder()
                .id(222).name("Marina").age(45).placeOfWork("Black Company").address("Lenin Street").build());
        users.add(User.builder()
                .id(547).name("Vladimir").age(45).placeOfWork("QWERTY Company").address("Moscow Street").build());
        users.add(User.builder()
                .id(352).name("Valery").age(25).placeOfWork("ABC Company").address("Lenin Street").build());
        users.add(User.builder()
                .id(333).name("Petr").age(33).placeOfWork("QWERTY Company").address("Kirov Street").build());

        printGroupedUsers(User.groupUsersByAge(users));
    }

    private static void printGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " - users: " + entry.getValue());
        }
    }
}
