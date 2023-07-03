package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Jin", 25, "Google", "Tokyo"));
        users.add(new User("Namjoon", 30, "Apple", "New York"));
        users.add(new User("V", 25, "Samsung", "Seoul"));
        users.add(new User("J-hope", 35, "Hybe", "Kazan"));
        users.add(new User("Suga", 25, "BangtanTv", "Pusan"));
        users.add(new User("Jimin", 30, "Ramen", "Krasnodar"));

        Map<Integer, List<User>> userByAge = User.groupUsers(users);
        System.out.println(userByAge);
    }
}

