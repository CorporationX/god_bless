package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User userRoma = new User("roma",17,"aaa","aasdf");
        User userStas = new User("Stas", 44,"asfasdf","asfd");

        List<User> listOfUsers = List.of(userRoma,userStas);

        groupUsers(listOfUsers);
    }
}
