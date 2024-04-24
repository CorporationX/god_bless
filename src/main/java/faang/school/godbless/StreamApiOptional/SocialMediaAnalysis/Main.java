package faang.school.godbless.StreamApiOptional.SocialMediaAnalysis;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static faang.school.godbless.StreamApiOptional.SocialMediaAnalysis.UserAction.generateRandomAction;
import static faang.school.godbless.StreamApiOptional.SocialMediaAnalysis.UserAction.generateRandomContent;
import static faang.school.godbless.StreamApiOptional.SocialMediaAnalysis.UserAction.generateRandomDate;
import static faang.school.godbless.StreamApiOptional.SocialMediaAnalysis.UserAction.generateRandomInt;
import static faang.school.godbless.StreamApiOptional.SocialMediaAnalysis.UserAction.generateRandomName;

public class Main {
    private static final List<UserAction> USER_ACTIONS = new ArrayList<>();
    private static final String[] HASHTAGS = {"#WOW", "#FUN", "#OMG", "#HOT", "#NEW", "#AMAZING"};

    public static void main(String[] args) {

        Main app = new Main();

        app.createUserActions();

        System.out.println("Top 10 Most Active Users:");
        Map<String, Long> top10ActiveUsers = app.getTop10MostActiveUsers();
        for (Map.Entry<String, Long> userAction : top10ActiveUsers.entrySet()) {
            System.out.println(userAction.getKey()
                    + " score: " + userAction.getValue());
        }

        System.out.println("\nTop 5 Most Discussed Topics:");
        Map<String, Long> top5DiscussedTopics = app.getTop5MostPopularTopics();
        for (Map.Entry<String, Long> topic : top5DiscussedTopics.entrySet()) {
            System.out.println(topic);
        }

        System.out.println("\nTop 5 Best Commenters:");
        Map<String, Long> bestCommenters = app.getTopBestCommenters();

        for (Map.Entry<String, Long> commenter : bestCommenters.entrySet()) {
            System.out.println(commenter.getKey() +
                    " commented: " + commenter.getValue() + " posts");
        }

        System.out.println("\nPercent of every action:");
        Map<String, String> percentOfActions = app.getPercentOfActions();
        for (Map.Entry<String, String> percent : percentOfActions.entrySet()) {
            System.out.println(percent.getKey() + ": " +
                    percent.getValue() + "%");
        }
    }

    public void createUserActions() {
        for (int i = 0; i < 100; i++) {
            addUserAction(
                    generateRandomInt(1, 12),
                    generateRandomName(),
                    generateRandomAction(),
                    generateRandomDate(),
                    generateRandomContent()
            );
        }
    }

    public void addUserAction(int id, String name, String action, String date, String content) {
        USER_ACTIONS.add(new UserAction(id, name, action, date, content));
    }

    public Map<String, Long> getTop10MostActiveUsers() {

        Map<String, Long> usersMap = USER_ACTIONS.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        Map<String, Long> sortedMap = sortMapByValue(usersMap);

        Map<String, Long> top10MostActiveUsersMap = new LinkedHashMap<>();

        AtomicInteger position = new AtomicInteger(1);

        sortedMap.entrySet().stream()
                .limit(10)
                .forEachOrdered(entry -> top10MostActiveUsersMap.put(
                        position.getAndIncrement() + ". " + entry.getKey(),
                        entry.getValue()));

        return top10MostActiveUsersMap;

    }

    public Map<String, Long> getTop5MostPopularTopics() {

        List<String> hashtagList = Arrays.stream(HASHTAGS).toList();

        Map<String, Long> topicsMap = USER_ACTIONS.stream()
                .filter(userAction -> hashtagList.stream().anyMatch(hashtag -> userAction.getContent().contains(hashtag)))
                .collect(Collectors.groupingBy(action -> {
                    for (String hashtag : hashtagList) {
                        if (action.getContent().contains(hashtag)) {
                            return hashtag;
                        }
                    }
                    return "";
                }, Collectors.counting()));

        Map<String, Long> sortedMap = sortMapByValue(topicsMap);

        AtomicInteger position = new AtomicInteger(1);

        Map<String, Long> topHashtags = new LinkedHashMap<>();

        sortedMap.entrySet().stream()
                .limit(10)
                .forEachOrdered(entry -> topHashtags.put(
                        position.getAndIncrement() + ". " + entry.getKey(),
                        entry.getValue()));

        return topHashtags;
    }

    public Map<String, Long> getTopBestCommenters() {

        Map<String, Long> commentsMap = USER_ACTIONS.stream()
                .filter(userAction -> userAction.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        Map<String, Long> sortedMap = sortMapByValue(commentsMap);

        AtomicInteger position = new AtomicInteger(1);

        Map<String, Long> topCommenters = new LinkedHashMap<>();

        sortedMap.entrySet().stream()
                .limit(5)
                .forEachOrdered(entry -> topCommenters.put(
                        position.getAndIncrement() + ". " + entry.getKey(),
                        entry.getValue()));

        return topCommenters;
    }

    public Map<String, String> getPercentOfActions() {

        Map<String, Long> userActivityMap = USER_ACTIONS.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Map<String, Long> sortedMap = sortMapByValue(userActivityMap);

        double sum = userActivityMap.values().stream().mapToDouble(Long::doubleValue).sum();

        DecimalFormat decimalFormatter = new DecimalFormat("#.##");

        Map<String, String> percent = new LinkedHashMap<>();

        AtomicInteger position = new AtomicInteger(1);

        sortedMap.forEach((key, value) -> {
            double percentage = (value * 100.0) / sum;
            percent.put(
                    position.getAndIncrement() + ". " + key,
                    decimalFormatter.format(percentage));
        });

        return percent;
    }

    private Map<String, Long> sortMapByValue(Map<String, Long> map) {

        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

}


