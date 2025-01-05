package user_activity_analysis;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserService {
    public List<String> handlerBestUsers(List<UserAction> userActionList) {
        Map<Integer, List<UserAction>> map;

        map = userActionList.parallelStream()
                .collect(Collectors.groupingBy(UserAction::getId));

        return map.entrySet().parallelStream()
                .sorted((entry2, entry1) -> Integer.compare(entry1.getValue().size(), entry2.getValue().size()))
                .limit(10)
                .map(entry -> entry.getValue().get(0).getName())
                .distinct()
                .toList();
    }

    public List<String> handlerBestMessage(List<UserAction> userActionList) {
        Pattern patternHashtag = Pattern.compile("#[a-zA-Z0-9_]+");
        Map<String, Long> numberHashtags;
        numberHashtags = userActionList.parallelStream()
                .filter(userAction -> userAction.getActionType().equalsIgnoreCase("comment"))
                .filter(userAction -> patternHashtag.matcher(userAction.getContent()).find())
                .flatMap(userAction -> patternHashtag.matcher(userAction.getContent()).results().map(MatchResult::group))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return numberHashtags.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .peek(entry -> System.out.printf("Хештег: %s количество упоминаний: %d ", entry.getKey(), entry.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> SearchBestCommentators(List<UserAction> userActionList) {
        Map<Integer, List<UserAction>> userActivity;
        LocalDate currentDate = LocalDate.now();

        userActivity = userActionList.parallelStream()
                .filter(userAction -> userAction.getActionType().equalsIgnoreCase("comment"))
                .filter(userAction -> !userAction.getActionDate().isBefore(currentDate.minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId));

        return userActivity.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .limit(3)
                .peek(entry -> System.out.println(entry.getValue().size() + " " + entry.getValue().get(0).getName()))
                .map(entry -> entry.getValue().get(0).getName())
                .toList();
    }

    public Map<String, Double> calculatorActivityPopularity(List<UserAction> userActionList) {
        Map<String, Double> stringDoubleMap = userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) entry.getValue() / userActionList.size() * 100));

        System.out.println("Подсчет % активностей по популярности: ");
        stringDoubleMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.printf("%s = %.2f%% ", entry.getKey(), entry.getValue()));
        return stringDoubleMap;
    }
}