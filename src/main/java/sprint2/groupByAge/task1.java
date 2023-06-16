package sprint2.groupByAge;

import java.util.List;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        User user1 = new User("Jon", 18,"xxYteam", "moscow" );
        User user2 = new User("Jake", 18,"Mail", "moscow" );
        User user3 = new User("Paul", 16,"Google", "moscow" );
        User user4 = new User("Violet", 17,"Stepic", "moscow" );
        List<User> list = List.of(user1,user2,user3,user4);

        Map<Integer, List<String>> result = User.groupUsers(list);

        System.out.println(result.get(18));

    }
}
