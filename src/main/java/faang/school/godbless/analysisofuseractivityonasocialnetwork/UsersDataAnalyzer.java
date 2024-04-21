package faang.school.godbless.analysisofuseractivityonasocialnetwork;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.experimental.ExtensionMethod;


@ExtensionMethod(FastBigDecimalPercentage.class)
public class UsersDataAnalyzer {
    public static List<UUID> getTop10MostActive(List<UserAction> actions) {
        TreeSet<Map.Entry<UUID, Long>> top10;

        top10 = new TreeSet<>(UsersDataAnalyzer.getCustomComparator());
        actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .forEach(entry -> UsersDataAnalyzer.getTopNumberOfElements(entry, top10, UsersDataAnalyzer.getCustomComparator(), 10));

        return top10.stream()
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop5MostPopularTopics(List<UserAction> actions) {
        Map<String, Long> hashTagToCount;
        TreeSet<Map.Entry<String, Long>> top5 = new TreeSet<>(UsersDataAnalyzer.getCustomComparator());

        hashTagToCount = actions.stream()
                .map(userAction -> UsersDataAnalyzer.getHashtagsList(userAction.getContent()))
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        hashTagToCount.entrySet()
                .forEach(entry -> UsersDataAnalyzer.getTopNumberOfElements(entry, top5, UsersDataAnalyzer.getCustomComparator(), 5));

        return top5.stream()
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<UUID> getTop3UsersWithMostCommentsInLastMonth(List<UserAction> actions) {
        TreeSet<Map.Entry<UUID, Long>> top3;
        top3 = new TreeSet<>(UsersDataAnalyzer.getCustomComparator());
        Predicate<UserAction> isComment = UsersDataAnalyzer::isComment;
        Predicate<UserAction> isCommentAndIsUserActionFromLastMonth = isComment.and(UsersDataAnalyzer::isUserActionFromLastMonth);

        actions.stream()
                .filter(isCommentAndIsUserActionFromLastMonth)
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()))
                .entrySet()
                .forEach(entry -> UsersDataAnalyzer.getTopNumberOfElements(entry, top3, UsersDataAnalyzer.getCustomComparator(), 3));

        return top3.stream()
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<UserActionType, BigDecimal> getPercentageForEachTypeOfAction(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> getPercentage(entry.getValue(), actions.size())));
    }

    private static <K, V> void getTopNumberOfElements(Map.Entry<K, V> entry,
                                                      TreeSet<Map.Entry<K, V>> listOfMax,
                                                      Comparator<Map.Entry<K, V>> comparator,
                                                      int top) {
        if (listOfMax.size() < top) {
            listOfMax.add(entry);
        } else {
            if (comparator.compare(listOfMax.last(), entry) > 0) {
                listOfMax.pollLast();
                listOfMax.add(entry);
            }
        }
    }

    private static List<String> getHashtagsList(String str) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(str);
        List<String> hashtagsList = new ArrayList<>();
        while (matcher.find()) {
            hashtagsList.add(matcher.group());
        }
        return hashtagsList;
    }

    private static <K> Comparator<Map.Entry<K, Long>> getCustomComparator() {
        return (entry1, entry2) -> Math.toIntExact(entry2.getValue() - entry1.getValue());
    }

    private static boolean isUserActionFromLastMonth(UserAction userAction) {
        LocalDate actionDate = userAction.getActionDate().toLocalDate();
        LocalDate now = LocalDate.now();
        LocalDate start = now.withDayOfMonth(1);
        LocalDate end = now.withDayOfMonth(now.getMonth().length(now.isLeapYear()));

        return actionDate.isAfter(start) && actionDate.isBefore(end);
    }

    private static boolean isComment(UserAction userAction) {
        return userAction.getActionType() == UserActionType.comment;
    }

    private static BigDecimal getPercentage(double valueDouble, double totalDouble) {
        BigDecimal obtained = new BigDecimal(valueDouble);
        BigDecimal total = new BigDecimal(totalDouble);
        return obtained.toPercentageOf(total);
    }
}
