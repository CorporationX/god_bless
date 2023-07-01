package Sprint_3_Task_Analiz;

import java.text.DecimalFormat;
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
                //.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                //убывание
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .toList();
    }

    public static List<Map.Entry<String, Long>> methodTop5(List<UserAction> userActions) {
        return userActions.stream()
                .filter(t1 -> t1.getActionType().equals(ActionType.POST) || t1.getActionType().equals(ActionType.COMMENT))
                .filter(t3 -> t3.getContent().startsWith("#"))
                //.toList().size();
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .toList();
    }
//        return userActions.stream()
//                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
//                .filter(str -> str.startsWith("#"))
//                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(5)
//                .map(Map.Entry::getKey)
//                .toList();

    public static List<Integer> methodTop3(List<UserAction> userActions) {
        return userActions.stream()
                .filter(t5 -> t5.getActionType().equals(ActionType.COMMENT))
                .filter(t6 -> ((LocalDate.now().getYear() == t6.getActionDate().getYear())
                        && (LocalDate.now().getMonth() == t6.getActionDate().getMonth())))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Map.Entry<ActionType, String>> actionsPercentage(List<UserAction> userActions) {
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(2));
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, i -> decimalFormat.format(i.getValue().doubleValue() * 100 / userActions.size())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //.sorted(Map.Entry.comparingByValue((int) Math.round(Comparator.reverseOrder())))
                //.map(Map.Entry::getValue)
                .toList();
    }

    public static void main(String[] args) {

        List<UserAction> userActions = List.of(
                new UserAction(1, "user1", ActionType.POST, LocalDate.of(2023, 7, 1), "#Bc_yu er ee"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.of(2023, 7, 1), "#important"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.of(2023, 7, 1), "p#ost"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.of(2023, 7, 1), "#BC"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.of(2023, 7, 1), "post"),
                new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now(), "#post"),
                new UserAction(1, "user1", ActionType.COMMENT, LocalDate.now(), "#post"),
                new UserAction(1, "user1", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(2, "user2", ActionType.COMMENT, LocalDate.now(), "#Bc"),
                new UserAction(3, "user3", ActionType.LIKE, LocalDate.now(), "#like"),
                new UserAction(4, "user4", ActionType.COMMENT, LocalDate.now(), "#important"),
                new UserAction(4, "user4", ActionType.LIKE, LocalDate.now(), "share"),
                new UserAction(4, "user4", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(5, "user5", ActionType.POST, LocalDate.now(), "#post"),
                new UserAction(5, "user5", ActionType.POST, LocalDate.now(), "p #ost"),
                new UserAction(5, "user5", ActionType.POST, LocalDate.now(), "#post"),
                new UserAction(6, "user6", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(6, "user6", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(6, "user6", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#Bc"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(6, "user6", ActionType.COMMENT, LocalDate.of(2023, 2, 1), "#IMPORTANT"),
                new UserAction(7, "user7", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(8, "user8", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(8, "user8", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(9, "user9", ActionType.POST, LocalDate.now(), "#sumer"),
                new UserAction(10, "user10", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(10, "user10", ActionType.COMMENT, LocalDate.now(), "#IMPORTANT"),
                new UserAction(10, "user10", ActionType.COMMENT, LocalDate.now(), "#IMPORTANT"),
                new UserAction(10, "user10", ActionType.COMMENT, LocalDate.now(), "#IMPORTANT"),
                new UserAction(10, "user10", ActionType.COMMENT, LocalDate.now(), "#IMPORTANT"),
                new UserAction(11, "user11", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(12, "user12", ActionType.LIKE, LocalDate.now(), "share"),
                new UserAction(12, "user12", ActionType.SHARE, LocalDate.now(), "#share"),
                new UserAction(13, "user13", ActionType.POST, LocalDate.now(), "post"),
                new UserAction(14, "user14", ActionType.LIKE, LocalDate.now(), "#comment"),
                new UserAction(14, "user14", ActionType.COMMENT, LocalDate.now(), "#comment"),
                new UserAction(14, "user14", ActionType.COMMENT, LocalDate.now(), "#sumer"),
                new UserAction(15, "user15", ActionType.LIKE, LocalDate.now(), "like"),
                new UserAction(16, "user16", ActionType.LIKE, LocalDate.now(), "#share"),
                new UserAction(16, "user16", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(16, "user16", ActionType.SHARE, LocalDate.now(), "share"),
                new UserAction(17, "user17", ActionType.LIKE, LocalDate.now(), "post"),
                new UserAction(17, "user17", ActionType.POST, LocalDate.now(), "#sumer"),
                new UserAction(17, "user17", ActionType.POST, LocalDate.now(), "#s"),
                new UserAction(17, "user17", ActionType.POST, LocalDate.now(), "#s")
        );
        System.out.println(methodTop10(userActions));
        System.out.println(methodTop5(userActions));
        System.out.println(methodTop3(userActions));
        System.out.println(actionsPercentage(userActions));
    }
}
