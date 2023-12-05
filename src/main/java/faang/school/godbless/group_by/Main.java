package faang.school.godbless.group_by;

import faang.school.godbless.registration.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("Olya", 23, "Audi", "Germany"));
        listUsers.add(new User("Vadim", 35,"BMW", "France"));
        listUsers.add(new User("Anna", 40,"FIAT", "Italy"));
        listUsers.add(new User("Boris", 35,"Audi", "Greece"));
        listUsers.add(new User("Ignat", 57,"KIA", "Japan"));

        System.out.println(listUsers);
        System.out.println(User.groupUsers(listUsers));


    }
}
