package faang.school.godbless.sprint2.activityAnalytics;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        UserAction content1 = new UserAction("1", ActionType.LIKE, LocalDateTime.now(), "content1 #theme5");
        UserAction content2 = new UserAction("3", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme5");
        UserAction content3 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme2");
        UserAction content4 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme6");
        UserAction content5 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme2");
        UserAction content6 = new UserAction("2", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme3");
        UserAction content7 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme1");
        UserAction content8 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme6");
        UserAction content16 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme3");
        UserAction content9 = new UserAction("2", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme3");
        UserAction content10 = new UserAction("2", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme1");
        UserAction content11 = new UserAction("2", ActionType.COMMENT, LocalDateTime.now(), "content1");
        UserAction content12 = new UserAction("1", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme2");
        UserAction content13 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme4");
        UserAction content14 = new UserAction("3", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme1");
        UserAction content15 = new UserAction("3", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme6");
        UserAction content17 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme2");
        UserAction content18 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme2");
        UserAction content19 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme1");
        UserAction content20 = new UserAction("4", ActionType.COMMENT, LocalDateTime.now(), "content1 #theme4");


        List<UserAction> userActions = Arrays.asList(content1, content2, content3, content4, content5, content6, content7, content8, content9,
                content10, content11, content12, content13, content14, content15, content16, content17, content18, content19, content20);

        List<Map<String, Long>> theMostActiveUsersByAction = UserAction.getTheMostActiveUsersByAction(userActions, ActionType.COMMENT, 10);
        System.out.println("top 3 most active by comments: " + theMostActiveUsersByAction);

        List<Map<String, Long>> theMostPopularThemes = UserAction.getTheMostPopularThemes(userActions, 5);
        System.out.println("top 5 most popular themes: " + theMostPopularThemes);

        List<Map<String, Long>> theMostActiveByCommentsLastMonth = UserAction.getTheMostActiveByCommentsLastMonth(userActions, 3);
        System.out.println("theMostActiveByCommentsLastMonth: " + theMostActiveByCommentsLastMonth);

        Map<ActionType, Double> allActivitiesInPercent = UserAction.getAllActivitiesInPercent(userActions);
        System.out.println("allActivitiesInPercent: " + allActivitiesInPercent);
    }
}
