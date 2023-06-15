package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("Kevin", 17, "Uber", "Amsterdam");
        User user2 = new User("Alan", 35, "Google", "New York");
        User user3 = new User("Laura Bradley", 35, "Amazon", "London");
        User user4 = new User("Mr. Henderson", 40, "Uber", "London");
        User user5 = new User("Kevin", 27, "Google", "Amsterdam");
        List<User> users = List.of(user1, user2, user3, user4, user5);
        for(Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()){
            System.out.println("age " + entry.getKey());
            for(User user : entry.getValue()){
                System.out.println(user.getName() + ": place of work - "+ user.getPlaceOfWork() + "; adress - " + user.getAddress());
            }
            System.out.println();
        }
    }
}
