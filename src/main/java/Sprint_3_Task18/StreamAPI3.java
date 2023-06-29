package Sprint_3_Task18;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI3 {

    public static List<Integer> FindTheTop10MostActiveUsers(List<UserAction> userActions){
        return userActions.stream()
                .collect((Collectors.groupingBy(UserAction::getId, Collectors.counting())))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
    public void Top5MostPopularUsers(List<UserAction> userActions) {

    }
    public void FindTop3UserByComment(List<UserAction> userActions){

    }
    public void CalculatePercentageOfActions(List<UserAction> userActions){

    }

    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Inna", ActionType.post, LocalDateTime.of(2020, 1, 1, 0, 0), "Hello Inna"),
                new UserAction(2, "Andrew", ActionType.comment, LocalDateTime.now(), "Hello Andrew"),
                new UserAction(3, "Vlad", ActionType.like, LocalDateTime.now(), "Hello Vlad"),
                new UserAction(4, "Robert", ActionType.share, LocalDateTime.now(), "Hello Robert"),
                new UserAction(5, "Anna", ActionType.post, LocalDateTime.now(), "Hello Anna"),
                new UserAction(6, "Sofia", ActionType.comment, LocalDateTime.now(), "Hello Sofia"),
                new UserAction(7, "Nikita", ActionType.like, LocalDateTime.now(), "Hello Nikita"),
                new UserAction(8, "Zlata", ActionType.share, LocalDateTime.now(), "Hello Zlata"),
                new UserAction(9, "Maria", ActionType.post, LocalDateTime.now(), "Hello Maria"),
                new UserAction(10, "Maksim", ActionType.comment, LocalDateTime.now(), "Hello Maksim"),
                new UserAction(11, "Mark", ActionType.like, LocalDateTime.now(), "Hello Mark"),
                new UserAction(12, "Bob", ActionType.share, LocalDateTime.now(), "Hello Bob")
        );
        System.out.println(StreamAPI3.FindTheTop10MostActiveUsers(userActions));
    }
}
