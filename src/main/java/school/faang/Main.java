package school.faang;

import school.faang.usergroup.User;
import java.util.List;
import static school.faang.usergroup.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("First", 25);
        User user2 = new User("Second", 20);
        User user3 = new User("Third", 25);
        User user4 = new User("Fourth", 23);
        User user5 = new User("Fifth", 22);
        User user6 = new User("Sixth", 23);
        User user7 = new User("Seventh", 23);
        User user8 = new User("Eighth", 35);
        User user9 = new User("Ninth", 15);
        User user10 = new User("Tenth", 25);

        List<User> userList = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        System.out.println(groupUsers(userList));
    }


}
