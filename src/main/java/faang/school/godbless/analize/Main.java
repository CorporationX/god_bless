package faang.school.godbless.analize;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.of(2023, 11, 18, 14, 37);
        LocalDateTime data1 = LocalDateTime.of(2023, 12, 3, 11, 55);
        LocalDateTime data2 = LocalDateTime.of(2023, 12, 12, 17, 36);
        LocalDateTime data3 = LocalDateTime.of(2023, 12, 11, 15, 56);
        LocalDateTime data4 = LocalDateTime.of(2023, 11, 22, 1, 12);
        LocalDateTime data5 = LocalDateTime.of(2023, 12, 18, 12, 23);
        LocalDateTime data6 = LocalDateTime.of(2023, 12, 17, 7, 32);
        List<UserAction> testUserActions = Arrays.asList(
                new UserAction(24522, "like", "post", data, "#Test post #Java #Programming"),
                new UserAction(24522, "comment", "share", data1, "#Nice post!"),
                new UserAction(34245, "post", "like", data2, "asdf"),
                new UserAction(34245, "post", "post", data3, "Another post #Programming #java"),
                new UserAction(34245, "comment", "comment", data4, "Great topic #Java!"),
                new UserAction(24352, "share", "share", data5, "dsafd"),
                new UserAction(63535, "comment", "comment", data6, "Great topic #Java!")
        );

        System.out.println(Top.topActive(testUserActions));
        System.out.println();
        System.out.println(Top.topPopular(testUserActions));
        System.out.println();
        System.out.println(Top.topComments(testUserActions));
        System.out.println();
        System.out.println(Top.percent(testUserActions));

    }

}
