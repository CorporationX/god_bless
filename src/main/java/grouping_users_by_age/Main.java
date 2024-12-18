package grouping_users_by_age;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <User> users = List.of(
                new User("Andre",15,"prostituts","Lenina 5"),
                new User("Kate",17,"Agent007","Lenina 3"),
                new User("Nina",17,"Agent008","Lenina 5"),
                new User("Pina",15,"Agent009","Lenina 6"),
                new User("Fina",14,"Bomj","Lenina 7"));

        System.out.println(User.groupUsers(users));
    }
}
