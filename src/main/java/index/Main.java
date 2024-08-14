package index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(0, "Ivan");
        List<Query> listUser1 = new ArrayList<>();
        listUser1.add(new Query(0, "тачки", 30));
        listUser1.add(new Query(2, "бары", 50));
        listUser1.add(new Query(1, "клубы", 38));

        User user2 = new User(1, "Kolya");
        List<Query> listUser2 = List.of(new Query(0,"Шаман - Я русский",23),
                                        new Query(1,"Путин в молодости", 45),
                                        new Query(2,"Как стать русским?", 25));




        Map<User, List<Query>> queryByUser = new HashMap<>();

        User.addUSer(queryByUser, user1, listUser1);
        User.addUSer(queryByUser, user2, listUser2);
       User.sortHistoryQuery(queryByUser);

    }
}
