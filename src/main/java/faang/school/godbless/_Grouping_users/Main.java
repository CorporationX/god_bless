package faang.school.godbless._Grouping_users;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        User user = new User();
        user.age=5;
        user.name="Jason";
        User user1 = new User();
        user1.name="Rick";
        user1.age=6;
        ArrayList<User> users=new ArrayList<>();
        users.add(user);
        users.add(user1);
        User.groupUsers(users);
    }
}
