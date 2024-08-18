package faang.school.godbless.BJS2_22565;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionLogsTool {
    public void viewTopTenMostActiveUsers(List<UserAction> userActionLogData) {
        viewMostRepeated(userActionLogData.stream(), UserAction::getUserId, 10);
    }

    public void viewTopFiveTopics(List<UserAction> userActionLogData) {
        Stream<String> topicStream = userActionLogData.stream()
                .filter(action -> Objects.nonNull(action.getContent()))
                .flatMap(UserActionLogsTool::getHashtagStream);
        viewMostRepeated(topicStream, topic -> topic, 5);
    }

    public void viewTopThreeUsersByCommentsLastMonth(List<UserAction> userActionLogData) {
        Stream<UserAction> userActionWithCommentsLastMonth = userActionLogData.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().isBefore(LocalDateTime.now().minusMonths(1)));
        viewMostRepeated(userActionWithCommentsLastMonth, UserAction::getUserId, 3);
    }

    public void viewPercentByActionType(List<UserAction> userActionLogData) {
        userActionLogData.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .forEach((type, amount) ->
                        System.out.println(type + ": " + (double) amount * 100 / userActionLogData.size() + " %")
                );
    }

    private static Stream<String> getHashtagStream(UserAction action) {
        String content = action.getContent();
        return Arrays.stream(content.split(" "))
                .filter(word -> word.startsWith("#"))
                .map(String::toLowerCase);
    }

    private <T, K> void viewMostRepeated(Stream<T> stream, Function<? super T, ? extends K> classifier, int size) {
        stream.collect(Collectors.groupingBy(classifier, Collectors.counting()))
                .entrySet().stream()
                .sorted((entryOne, entryTwo) -> entryTwo.getValue().compareTo(entryOne.getValue()))
                .limit(size)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}