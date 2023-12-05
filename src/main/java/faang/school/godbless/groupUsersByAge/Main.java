package faang.school.godbless.groupUsersByAge;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> exampleList = List.of(new User("Tom",27),new User("Ken",27),
                new User("Kate",18),new User("Sara",18),new User("Bob",21),
                new User("Tim",20),new User("Ivan",21),new User("Niki",27));
        for(Map.Entry<Integer,List<User>> entry: User.groupUsers(exampleList).entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}
