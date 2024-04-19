package faang.school.godbless.analysingUserActivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = List.of(new UserAction(1, "Max", "post", LocalDate.of(2024, 4, 12), "#programming"),
                new UserAction(1, "Max", "comment", LocalDate.of(2024, 4, 12), "#programming"),
                new UserAction(2, "Nikita", "post", LocalDate.of(2024, 4, 12), "#programming"),
                new UserAction(2, "Nikita", "comment", LocalDate.of(2024, 3, 29), "#gaming"),
                new UserAction(1, "Max", "share", LocalDate.of(2024, 3, 11), "#faang"));

        top10MostActiveUsers(actions);
        top5PopularTopics(actions);
        top3UserComentorsInLastMonth(actions);
        activityPercentage(actions);

    }


    public static void top10MostActiveUsers(List<UserAction> actionList){
        Map<Integer,String> idName = actionList.stream()
                .collect(Collectors.toMap(
                        UserAction::getUserId,
                        UserAction::getUserName,
                        (existingValue, newValue)->existingValue)
                );

        actionList.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId,Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(entry -> System.out.println(idName.get(entry.getKey())));
    }

    public static void top5PopularTopics(List<UserAction> actionList){
        Map<String, Long> topicHash = actionList.stream()
                .filter(userAction -> userAction.getContent()!= null)
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word->word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        topicHash.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void top3UserComentorsInLastMonth (List<UserAction> actionList){
        Map<Integer,String> idName = actionList.stream()
                .collect(Collectors.toMap(
                                UserAction::getUserId,
                                UserAction::getUserName,
                                (existingValue, newValue)->existingValue)
                );
        actionList.stream()
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(idName.get(entry.getKey())));
    }

    public static void activityPercentage (List<UserAction> actionList){
        actionList.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " percentage: " + (value * 100 / actionList.size())+"%"));
    }

}
