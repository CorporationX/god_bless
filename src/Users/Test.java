package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<Users> users = new ArrayList<>();
        users.add(new Users("Jin", 25, "Google", "Tokyo"));
        users.add(new Users("Namjoon", 30, "Apple", "New York"));
        users.add(new Users("V", 25, "Samsung", "Seoul"));
        users.add(new Users("J-hope", 35, "Hybe", "Kazan"));
        users.add(new Users("Suga", 25, "BangtanTv", "Pusan"));
        users.add(new Users("Jimin", 30, "Ramen", "Krasnodar"));

        Map<Integer, List<Users>> userByAge = Users.groupUsers(users);
        System.out.println(userByAge);
    }
}

