package BJS2_18537;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        userList.add(new User("Sergey", 22, "MosTransport", "Moscow"));
        userList.add(new User("Andrew", 25, "Institute", "Novosibirsk"));
        userList.add(new User("Misha", 25, "Restaurant", "Almaty"));
        userList.add(new User("Vera", 22, "Night-Club", "Saint-Petersburg"));
        userList.add(new User("Masha", 30, "Area51", "Unknown"));
        userList.add(new User("Vlad", 30, "FAANG-School", "Amsterdam"));

        System.out.println(User.groupUsers(userList));
    }
}
