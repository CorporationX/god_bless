package faang.school.godbless.task_4;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var firstUserActivities = Set.of("Coding", "Football");
        var firstUser = new User(0, "Kostya", 17, firstUserActivities);
        var secondUserActivities = Set.of("BasketBall", "Volleyball");
        var secondUser = new User(1, "Andrei", 18, secondUserActivities);
        var thirdUserActivities = Set.of("Running", "Hockey");
        var thirdUser = new User(2, "Bob", 20, thirdUserActivities);
        var userList = List.of(firstUser, secondUser, thirdUser);
        var activiesSet = Set.of("Football", "Coding", "Hockey");
        var collectedUsers = User.findHobbyLovers(userList, activiesSet);
        System.out.println(collectedUsers);
    }
}
