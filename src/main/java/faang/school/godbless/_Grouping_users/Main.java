package faang.school.godbless._Grouping_users;


import java.util.List;

public class Main {
    public static void main(String [] args){
        User user1 = new User();
        user1.age=35;
        user1.name="Jack";
        User user = new User();
        user.age=18;
        user.name="Jason";

        List<User> users=List.of(user,user1);

        System.out.println(User.groupUsers(users));


    }
}
