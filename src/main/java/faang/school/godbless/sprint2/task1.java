package faang.school.godbless.sprint2;

import java.util.List;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        User user1 = new User("", 18,"Google", "London" );
        User user2 = new User("Jake", 18,"Uber", "New York" );
        User user3 = new User("Paul", 16,"Google", "Amsterdam" );
        User user4 = new User("Violet", 18,"Yandex", "London" );
        User user5 = new User("Violet", 18,"Uber", "Los Angeles" );
        List<User> list = List.of(user1,user2,user3,user4,user5);

        Map<Integer, List<String>> result = User.groupUsers(list);

        System.out.println(result.get(18));

    }
}
