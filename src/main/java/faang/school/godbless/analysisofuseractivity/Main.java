package faang.school.godbless.analysisofuseractivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<UserAction> actions = List.of(new UserAction(1, "Max", "post", LocalDate.of(2024, 4, 12), "#programming")
                , new UserAction(1, "Max", "comment", LocalDate.of(2024, 4, 12), "#programming")
                , new UserAction(2, "Nikita", "post", LocalDate.of(2024, 4, 12), "#programming")
                , new UserAction(2, "Nikita", "comment", LocalDate.of(2024, 3, 29), "#gaming")
                , new UserAction(1, "Max", "share", LocalDate.of(2024, 3, 11), "#faang"));

        findTop10ActiveUsers(actions);
        System.out.println();

        findTop5PopularTopics(actions);
        System.out.println();

        findTop3ActiveUsersByComment(actions);
        System.out.println();

        calculatePercentageForEachTypeOfAction(actions);
    }

    private static void findTop10ActiveUsers(List<UserAction> actions) {
        actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10).forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void findTop5PopularTopics(List<UserAction> actions) {
        actions.stream()
                .filter(action -> action.getActionType().equals("post") || action.getActionType().equals("comment"))
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5).forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void findTop3ActiveUsersByComment(List<UserAction> actions) {
        actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().getMonth().equals(LocalDate.now().getMonth()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).forEach(entry -> System.out.println(entry.getKey()));
    }

    private static void calculatePercentageForEachTypeOfAction(List<UserAction> actions) {
        actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + ((entry.getValue() * 100.0) / actions.size())));
    }

}
