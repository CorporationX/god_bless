package Sprint_3_Task_Analiz;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalysisUsers {
    //List <UserAction> userActions = new ArrayList<>();


    public static List<Map.Entry<Integer, Long>> methodTop10(List<UserAction> userActions) {

       return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList();

    }

    public static List <UserAction> methodTop5 (List<UserAction> userActions) {
        return userActions.stream()
                .flatMap(userAction -> userAction.getActions().stream())


    }

    public static void main(String[] args) {

        List<UserAction> userActions = List.of(
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now(), "#post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(2, "user2", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now(), "comment"),
                new UserAction(3, "user3", ActionType.LIKE, LocalDate.now(), "#like"),
                new UserAction(4, "user4", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(4, "user4", ActionType.LIKE, LocalDate.now(), "share"),
                new UserAction(4, "user4", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(4, "user4", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(5, "user5", ActionType.POST, LocalDate.now(), "#post"),
                new UserAction(6, "user6", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.now(), "comment"),
                new UserAction(7, "user7", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(8, "user8", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(8, "user8", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(8, "user8", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(9, "user9", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(10, "user10", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(10, "user10", ActionType.COMMENT, LocalDate.now(), "comment"),
                new UserAction(11, "user11", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(12, "user12", ActionType.LIKE, LocalDate.now(), "share"),
                new UserAction(12, "user12", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(13, "user13", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(14, "user14", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(14, "user14", ActionType.COMMENT, LocalDate.now(), "#comment"),
                new UserAction(14, "user14", ActionType.COMMENT, LocalDate.now(), "comment"),
                new UserAction(15, "user15", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(16, "user16", ActionType.LIKE, LocalDate.now(), "#share"),
                new UserAction(16, "user16", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(16, "user16", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(17, "user17", ActionType.LIKE, LocalDate.now(), "post"),
                new UserAction(17, "user17", ActionType.POST, LocalDate.now(), "#post")
        );
        System.out.println(method1(userActions));


    }
}
