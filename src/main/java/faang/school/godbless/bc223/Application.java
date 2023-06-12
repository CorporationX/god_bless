package faang.school.godbless.bc223;

import java.util.ArrayList;

    public class Application {
        public static void main(String... args) {
            User user1 = new User("Вася", 25, "mesto", "LA");
            User user2 = new User("коля", 25, "raboty", "Chita");
            User user3 = new User("галина", 30, "rabotymesto", "Gorod");
            User user4 = new User("champ", 30, "mestomesta", "neGorod");
            User user5 = new User("Джордж", 5, null, "example");

            ArrayList<User> list = new ArrayList<>(){{
                add(user1);
                add(user2);
                add(user3);
                add(user4);
                add(user5);
            }};

            System.out.println(User.groupUsers(list));
        }
    }

