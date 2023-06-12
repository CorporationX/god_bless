package faang.school.godbless.bc223;

import java.util.List;

public class Application {
        public static void main(String... args) {

            User user1 = new User("Вася", 25, "Google", "New York");
            User user2 = new User("коля", 25, "Uber", "London");
            User user3 = new User("галина", 30, "Google", "London");
            User user4 = new User("champ", 30, "Amazon", "Amsterdam");
            User user5 = new User("Джордж", 5, null, "New York");

            List<User> usersGroupByAge = List.of(user1,user2,user3,user4,user5);
            System.out.println(User.groupUsers(usersGroupByAge));
        }
    }

