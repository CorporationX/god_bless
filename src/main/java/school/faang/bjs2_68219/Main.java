package school.faang.bjs2_68219;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> infoUsers = new ArrayList<>();
        infoUsers.add(User.builder().name("Alena").age(50).address("Moscow").workPlace("Amazon").build());
        infoUsers.add(User.builder().name("Elena").age(34).address("London").workPlace("Loc").build());
        infoUsers.add(User.builder().name("Mark").age(13).address("NY").workPlace("Google").build());
        infoUsers.add(User.builder().name("Alex").age(65).address("Kemer").workPlace("Walmart").build());

        System.out.println(User.groupUsers(infoUsers));

    }
}
