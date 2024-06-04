package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User("Vlad", 17,"McDonald's","Rostov, Lenina street");
        User user2 = new User("Gleb", 22,"Ozon","Saint Petersburg");
        User user3 = new User("Zlata", 32,"Yandex","Voronezh");
        User user4 = new User("Varvara", 17,"LV Store consultant","Moscow");
        User user5 = new User("Nikolas", 24,"Suhoi Engineer","Illinois");
        User user6 = new User("Mathew", 22,"Suhoi","Chicago");
        User user7 = new User("Jennifer", 17,"Pizza Promoter","New York");
        User user8 = new User("Andrew", 30,"T1 Java developer","Moscow");
        User user9 = new User("Alice", 35,"Sber Lead Java developer","Novosibirsk");
        User user10 = new User("Jane", 35,"Bethesda","Melbourne");
        User user11 = new User("Merry", 24,"FlowWow","Rostov");
        User user12 = new User("Lisa", 30,"CarMain's Mechanic","Ekaterinburg");
        User user13 = new User("Arnold", 27,"Sber Security","Moscow");
        User user14 = new User("Gwen", 17,"McDonald's","Odessa");
        User user15 = new User("Michael", 35,"McDonald's","Ivanovo");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        users.add(user14);
        users.add(user15);
        Map<Integer,List<User>> groupedUsers = User.groupUsers(users);
        System.out.println(groupedUsers);
    }
}