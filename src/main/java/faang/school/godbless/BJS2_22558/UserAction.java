package faang.school.godbless.BJS2_22558;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserAction {
    private int id;
    private String name;
    private ActionTypes actionType;
    private String content;
    private LocalDate actionDate;

    private static final int MATH_HUNDRED = 100;

    public static List<Integer> getTop10MostActiveUsers(List<UserAction> actions){
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(List::size, Comparator.reverseOrder()))) //Comparator.comparing(pair -> pair.getValue().size())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List findTop5PopularThemes(List<UserAction> actions){
        return actions
                .stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(content -> content.contains("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .toList();
    }

    public static List findTop3UserByComments(List<UserAction> actions){
        return actions
                .stream()
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().withDayOfMonth(1)))
                .filter(action -> action.getActionType().equals(ActionTypes.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .toList();
    }

    public static Map getActionsByPercentage(List<UserAction> actions){
        return actions
                .stream()
                .map(UserAction::getActionType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * MATH_HUNDRED / actions.size()));
    }
}
