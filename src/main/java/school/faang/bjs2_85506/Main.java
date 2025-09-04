package school.faang.bjs2_85506;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Ivan", 25, "TalTech", "Laki 1");
        User user2 = new User("Dmitri", 35, "K+N", "Sompa 24");
        User user3 = new User("Natalya", 25, "TempTrans", "Läänemere 47");
        User user4 = new User("Sonya", 45, "Swedbank", "Ümera 6");
        User user5 = new User("Kristina", 35, "Microsoft", "Raua 34");
        User user6 = new User("Anatoliy", 25, "NY Pizza", "Peetri 34");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        System.out.println(User.groupUsers(users));
    }
}