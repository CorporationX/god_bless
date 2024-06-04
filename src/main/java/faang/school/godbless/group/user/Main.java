package faang.school.godbless.group.user;

import lombok.NonNull;

import java.util.List;

@NonNull
public class Main {
    public static void main(String[] args) {
        User userAlex = new User("Alex", 22, "Google", "NewYork");
        User userJoe = new User("Joe", 25, "Sony", "Los Angeles");
        User userDiana = new User("Diana", 33, "BBC", "London");
        User userBob = new User("Bob", 22, "Sony", "London");
        List<User> listOfUser = List.of(userJoe, userDiana, userAlex, userBob);
        User.groupUsers(listOfUser);
        User.showUsersGroupedByAge(listOfUser);
    }
}