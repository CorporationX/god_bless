package faang.school.godbless.groupUsersByAge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        userList.add(new User("Maria", 36, "JokGroup", "Minsk"));
        userList.add(new User("Nik", 24, "Ntkost", "Moscow"));
        userList.add(new User("Max", 30, "FEnergy", "Ufa"));
        userList.add(new User("Ksenia", 24, "BookShop", "Mogilev"));
        userList.add(new User("Boris", 30, "GHConsulting", "Minsk"));
        userList.add(new User("Vadim", 24, "NOK", "Moscow"));

        for (var entry : User.groupUser(userList).entrySet()) {
            System.out.println(entry);
        }
    }
}



