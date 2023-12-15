package faang.school.godbless.stream_api.analysis_of_user_activity_on_a_social_network;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static faang.school.godbless.stream_api.analysis_of_user_activity_on_a_social_network.ActionType.*;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActionList =
                List.of(new UserAction(new User(1, "Sultan"), POST, LocalDateTime.of(2023, 6, 12, 17, 35), "A post on the topic #anime"),
                        new UserAction(new User(2, "Almat"), POST, LocalDateTime.of(2022, 6, 15, 17, 35), "A post on the topic #sprinter"),
                        new UserAction(new User(3, "Bakha"), POST, LocalDateTime.of(2021, 6, 22, 17, 35), "A post on the topic #doors"),
                        new UserAction(new User(4, "Ulan"), POST, LocalDateTime.of(2020, 6, 21, 17, 35), "A post on the topic ##finance"),
                        new UserAction(new User(1, "Sultan"), COMMENT, LocalDateTime.of(2023, 7, 12, 17, 35), "#anime naruto"),
                        new UserAction(new User(3, "Bakha"), LIKE, LocalDateTime.of(2023, 5, 9, 17, 35), ""),
                        new UserAction(new User(3, "Bakha"), SHARE, LocalDateTime.of(2023, 8, 8, 17, 35), ""),
                        new UserAction(new User(3, "Bakha"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "The #doors are a top"),
                        new UserAction(new User(1, "Sultan"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "#anime onepunchman"),
                        new UserAction(new User(4, "Ulan"), POST, LocalDateTime.of(2026, 1, 6, 17, 35), "A post on the topic ##finance 2"),
                        new UserAction(new User(3, "Bakha"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "#Doors are the best thing in my life"),
                        new UserAction(new User(1, "Sultan"), POST, LocalDateTime.of(2015, 2, 6, 17, 35), "A post on the topic #anime 2"),
                        new UserAction(new User(1, "Sultan"), SHARE, LocalDateTime.of(2019, 4, 4, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "Game #csgo2 super"),
                        new UserAction(new User(2, "Almat"), LIKE, LocalDateTime.of(2021, 5, 11, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), LIKE, LocalDateTime.of(2021, 5, 11, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "I love #iphone comment 2"),
                        new UserAction(new User(1, "Sultan"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "#anime one love"),
                        new UserAction(new User(6, "Arman"), LIKE, LocalDateTime.of(2021, 5, 11, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2021, 7, 11, 17, 35), ""),
                        new UserAction(new User(2, "Almat"), LIKE, LocalDateTime.of(2021, 3, 11, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "I love #iphone"),
                        new UserAction(new User(6, "Arman"), LIKE, LocalDateTime.of(2021, 2, 11, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), LIKE, LocalDateTime.of(2021, 1, 11, 17, 35), ""),
                        new UserAction(new User(3, "Bakha"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "The #doors are a top"),
                        new UserAction(new User(2, "Almat"), LIKE, LocalDateTime.of(2013, 5, 5, 17, 35), ""),
                        new UserAction(new User(2, "Almat"), LIKE, LocalDateTime.of(2021, 5, 11, 17, 35), ""),
                        new UserAction(new User(2, "Almat"), POST, LocalDateTime.of(2011, 6, 12, 17, 35), "A post on the topic #sprinter 2"),
                        new UserAction(new User(4, "Ulan"), LIKE, LocalDateTime.of(2012, 6, 12, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2023, 7, 2, 14, 32), "#csgo2 the best game"),
                        new UserAction(new User(4, "Ulan"), SHARE, LocalDateTime.of(2007, 6, 12, 17, 35), "A post on the topic #anime"),
                        new UserAction(new User(1, "Sultan"), COMMENT, LocalDateTime.of(2006, 7, 1, 17, 35), "#anime onepiece"),
                        new UserAction(new User(2, "Almat"), LIKE, LocalDateTime.of(2014, 3, 28, 17, 35), ""),
                        new UserAction(new User(5, "Ernar"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "I love #iphone comment"),
                        new UserAction(new User(1, "Sultan"), SHARE, LocalDateTime.of(2012, 4, 7, 17, 35), ""),
                        new UserAction(new User(3, "Bakha"), COMMENT, LocalDateTime.of(2016, 7, 1, 17, 35), "The #doors made of wood are the best"),
                        new UserAction(new User(1, "Sultan"), SHARE, LocalDateTime.of(2015, 6, 2, 17, 35), ""),
                        new UserAction(new User(1, "Sultan"), COMMENT, LocalDateTime.of(2023, 7, 3, 17, 35), "#anime bleach")
                );


        System.out.println(topUser(userActionList));
        topPopularDiscussionTopics(userActionList);
        System.out.println(topUserByDate(userActionList, LocalDateTime.of(2023, 7, 3, 17, 35)));
        System.out.println(calculatePercent(userActionList));


    }


    static List<User> topUser(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()))
                .entrySet().stream().sorted((c1, c2) -> Math.toIntExact(c2.getValue() - c1.getValue()))
                .limit(5)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

    }


    static void topPopularDiscussionTopics(List<UserAction> userActions) {
        Pattern pattern = Pattern.compile("#\\w+");
        userActions
                .stream()
                .filter(userAction -> userAction.getActionType().equals(POST) || userAction.getActionType().equals(COMMENT))
                .map(userAction -> userAction.getContent())
                .filter(content -> content != null && !content.isEmpty() && pattern.matcher(content).find())
                .collect(Collectors.groupingBy(content -> {
                    Matcher matcher = pattern.matcher(content.toLowerCase());
                    matcher.find();
                    return matcher.group();
                }, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> Math.toIntExact(v2.getValue() - v1.getValue()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }


    static Map<User, Long> topUserByDate(List<UserAction> userActions, LocalDateTime dateTime) {
        return userActions.stream()
                .filter(userAction -> userAction.getActionType().equals(COMMENT) && userAction.getActionDate().getMonth().equals(dateTime.getMonth()))
                .collect(Collectors.groupingBy(UserAction::getUser, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Math.toIntExact(c2.getValue() - c1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Если есть дубликаты ключей, сохраняем старое значение
                        LinkedHashMap::new
                ));
    }


    static Map<ActionType, Double> calculatePercent(List<UserAction> userActions) {
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / userActions.size()));
    }


}


@Data
@AllArgsConstructor
class User {
    private int id;
    private String name;
}


@Data
@AllArgsConstructor
class UserAction {
    private User user;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}

enum ActionType {

    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private String typeText;

    ActionType(String typeText) {
        this.typeText = typeText;
    }

}