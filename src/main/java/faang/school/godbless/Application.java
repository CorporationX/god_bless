package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("Kevin Flynn", 35, "ENCOM", "Center-City");
        User user2 = new User("Alan Bradley", 35, "ENCOM", "Center-City");
        User user3 = new User("Laura Bradley", 35, "ENCOM", "Center-City");
        User user4 = new User("Mr. Henderson", 40, "Savings & Loan", "Washington");
        User user5 = new User("Kevin Flynn", 27, "ENCOM", "Center-City");
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
