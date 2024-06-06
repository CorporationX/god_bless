package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Map<Integer, List<User>> result;

        users.add(new User("John", 33, "Google", "761 Angus Road"));
        users.add(new User("Katy", 31, "Amazon", "4414 Farm Meadow Drive"));
        users.add(new User("Peter", 33, "Uber", "1842 Breezewood Court"));
        users.add(new User("Michael", 23, "Facebook", "2207 Shinn Avenue"));
        users.add(new User("Sam", 33, "Uber", "4088 Drummond Street"));
        users.add(new User("Bob", 22, "Google", "3938 Tenmile"));
        users.add(new User("Ellie", 22, "Google", "436 Indiana Avenue"));
        users.add(new User("Steve", 33, "Amazon", "3226 Foley Street"));
        users.add(new User("Jimmy", 31, "Facebook", "507 Edgewood Road"));
        users.add(new User("Carl", 21, "Netflix", "467 Jennifer Lane"));

        result = User.groupUsers(users);

        for (List<User> list : result.values()) {
            for (User user : list){
                System.out.println("Name: "+user.getName()+" Age: "+user.getAge());
            }
            System.out.println("_____________");
        }
    }
}