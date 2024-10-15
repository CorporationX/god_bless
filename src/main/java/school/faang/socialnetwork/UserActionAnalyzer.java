package school.faang.socialnetwork;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topUsers(List<UserAction> list) {
        Map<Integer, List<UserAction>> usersActions = list.stream().collect(Collectors.groupingBy(UserAction::getId));

        return usersActions.values().stream()
                .sorted(Comparator.comparing(List::size, (item1, item2) -> item2 - item1))
                .limit(10)
                .map(el -> el.get(0).getName())
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> list) {
            return list.stream()
                .filter(el -> el.getContent().contains("#"))
                .map(el -> {
                    System.out.println(el);
                    return getHashTag(el);
                })
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet().stream()
                .sorted((el1, el2) -> Math.toIntExact(el2.getValue() - el1.getValue()))
                .limit(5)
                .map(Entry::getKey)
                .toList();
    }

    public static String getHashTag(UserAction userAction) {
        Pattern pattern = Pattern.compile("#[a-zA-Z]+");
        Matcher matcher = pattern.matcher(userAction.getContent());

        return matcher.group();
    }
}



