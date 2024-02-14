package Basic.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User sam = new User("sam",20, "tinkoff","street1");
        User vlad = new User("vlad",20, "uber","street2");
        User artem = new User("artem",24, "sber","street3");
        User alex = new User("alex",24, "ozon","street4");
        User david = new User("david",20, "alfa","street5");
        List<User> users = new ArrayList<>();
        users.add(sam);
        users.add(vlad);
        users.add(artem);
        users.add(alex);
        users.add(david);
        Map<Integer, List<User>> integerListMap = User.groupUsers(users);
        System.out.println(integerListMap);
    }
}
