package faang.school.godbless.collectUsers;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> listUsers = List.of(new User(1,"Tom",20, Set.of("hiking","swiwing")),
                new User(1,"Ken",22, Set.of("reading")),
                new User(1,"Ivan",30, Set.of("hiking","ski")),
                new User(1,"Bob",26, Set.of("walking")),
                new User(1,"Roma",23, Set.of("snowboard","hiking")));

        Map<User,String> userStringMap = new User().findHobbyLovers(listUsers,Set.of("hiking","walking"));
        for (Map.Entry<User,String> entry : userStringMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

}
