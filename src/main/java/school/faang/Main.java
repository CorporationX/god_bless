package school.faang;

import school.faang.groupByAge.User;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Kirill A", 25, "Yastriy Lom 23", "Yastriy Lom 20");
        User user2 = new User("Sofya B", 32, "Macha Ria 55", "Macha Ria 50");
        User user3 = new User("Vitaliy C", 29, "Groun Parra 63", "Groun Parra 60");
        User user4 = new User("Maksim D", 45, "Pronto Ser 66", "Pronto Ser 60");
        User user5 = new User("Evgeniy E", 45, "Gerro Tes 707", "Gerro Tes 700");

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5);

        User.groupUsers(userList);
    }
}
