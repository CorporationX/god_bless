package faang.school.godbless.bjs2_18412;

import java.util.List;
import java.util.Set;

import static faang.school.godbless.bjs2_18412.ActivityConstants.BASKETBALL;
import static faang.school.godbless.bjs2_18412.ActivityConstants.CODING;
import static faang.school.godbless.bjs2_18412.ActivityConstants.FOOTBALL;
import static faang.school.godbless.bjs2_18412.ActivityConstants.READING;
import static faang.school.godbless.bjs2_18412.ActivityConstants.RUNNING;
import static faang.school.godbless.bjs2_18412.ActivityConstants.VOLLEYBALL;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(1, "", null, Set.of(FOOTBALL, BASKETBALL));
        var user2 = new User(2, "", null, Set.of(VOLLEYBALL));
        var user3 = new User(3, "", null, Set.of(RUNNING, FOOTBALL));
        var user4 = new User(4, "", null, Set.of(READING));
        var user5 = new User(5, "", null, Set.of(CODING, FOOTBALL, RUNNING));

        var users = List.of(user1, user2, user3, user4, user5);

        var case1 = Set.of(FOOTBALL, READING);
        var case2 = Set.of(RUNNING);
        var case3 = Set.of(FOOTBALL, BASKETBALL, VOLLEYBALL, RUNNING);

        var result1 = User.findHobbyLovers(users, case1);
        var resultJava81 = User.findHobbyLoversJava8(users, case1);
        User.printHobbyLovers(result1);
        User.printHobbyLovers(resultJava81);

        System.out.println("----------------");

        var result2 = User.findHobbyLovers(users, case2);
        var resultJava82 = User.findHobbyLoversJava8(users, case2);
        User.printHobbyLovers(result2);
        User.printHobbyLovers(resultJava82);

        System.out.println("----------------");

        var result3 = User.findHobbyLovers(users, case3);
        var resultJava83 = User.findHobbyLoversJava8(users, case3);
        User.printHobbyLovers(result3);
        User.printHobbyLovers(resultJava83);
    }
}
