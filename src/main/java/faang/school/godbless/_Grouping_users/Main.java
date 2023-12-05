package faang.school.godbless._Grouping_users;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args){
        User user = new User();
        user.age=5;
        user.name="Jason";
        ArrayList<User> users=new ArrayList<>();
        users.add(user);
        User.groupUsers(users);
    }
}
