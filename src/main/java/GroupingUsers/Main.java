package GroupingUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User userSanje = new User("Sanje", 20);
        User userMarina = new User("Marina", 18);
        User userDorjy = new User("Dorjy", 16);
        User userDashy = new User("Dashy", 16);
        User userBayasana = new User("Bayasana", 11);
        User userAnya = new User("Anya", 11);
        User userDari = new User("Dari", 11);

        List<User> usersList = new ArrayList<>();
        usersList.add(userSanje);
        usersList.add(userMarina);
        usersList.add(userDorjy);
        usersList.add(userDashy);
        usersList.add(userBayasana);
        usersList.add(userAnya);
        usersList.add(userDari);

        System.out.println(User.groupUsers(usersList));
    }
}
