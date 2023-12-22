package faang.school.godbless.AnalysUserActivityOnSocialNetwork;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ActivityAnalysis {
    // Найти топ-10 самых активных пользователей
    // (по количеству действий: посты, комментарии, лайки и репосты).

    public static List<String> top10ActiveUser(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Math.toIntExact(entry2.getValue() - entry1.getValue()))
                .limit(3)  // по задаче нужен лимит 10
                .map(Map.Entry::getKey)
                .toList();
    }

    // Определить Топ-5 наиболее популярных тем обсуждения
    // (по количеству упоминаний хештегов в постах и комментариях. Хэштег — слово, начинающееся с символа #).
    public static void top5PopularTopics(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("#\\w+");
        userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("COMMENT") || userAction.getActionType().equals("POST"))
                .map(userAction -> userAction.getContent())
                .filter(content -> content != null && content.contains("#"))
                .collect(Collectors.groupingBy(content -> {
                    Matcher matcher = pattern.matcher(content.toLowerCase());
                    matcher.find();   //начинаем поиск
                    return matcher.group(); //вытаскиваем слово
//получается, что ловит только первое слово с "#". Хотела написать через while, но тогда не пойму, что возвращать надо
                    //while (matcher.find())
                    //  return matcher.group()
                }, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Math.toIntExact(entry2.getValue() - entry1.getValue()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

    // Найти Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц
    public static List<String> top3UsersMostComments(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("COMMENT") && userAction.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Math.toIntExact(entry2.getValue() - entry1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Вычислить процент действий (посты, комментарии, лайки и репосты) для каждого типа действий
    public static Map<String, Double> percentAction(List<UserAction> userActions) {
        int countElements = userActions.size();
        Map<String, Long> usersActives = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        Map<String, Double> persentActions = usersActives.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / countElements));
        return persentActions;
    }
}

