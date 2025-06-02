package school.faang.BJS279138;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Pavel", 18, "Промсвязьбанк", "Загорьевская, 1"));
        userList.add(new User("Jon", 19, "Промсвязьбанк", "Загорьевская, 2"));
        userList.add(new User("Kate", 18, "Промсвязьбанк", "Загорьевская, 3"));
        userList.add(new User("Misha", 18, "Промсвязьбанк", "Загорьевская, 4"));
        userList.add(new User("Vlad", 19, "Промсвязьбанк", "Загорьевская, 5"));
        userList.add(new User("Igor", 20, "Промсвязьбанк", "Загорьевская, 6"));
        System.out.println(User.groupUsers(userList).toString());
    }
}
