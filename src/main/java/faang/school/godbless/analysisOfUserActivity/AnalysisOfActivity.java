package faang.school.godbless.analysisOfUserActivity;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AnalysisOfActivity {

    private final List<User> USERS = new ArrayList<>();

    public List<Integer> topActiveUsers(List<User> USERS) { // 10 самых активных пользователей
        Map<Integer, List<User>> map = USERS.stream() // key - айди юзера, value - лист юзеров
                .collect(Collectors.groupingBy(User::getId));

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<User>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public List<String> mostPopularTopics(List<User> USERS) { // 5 самых обсуждаемых тем
        Map<String, Long> nameTopicAndCount = USERS.stream() // key - тип контента  value - кол-во обсуждений
                .flatMap(a -> Arrays.stream(a.getContent().split("\\s"))) // из неск. потов в один и в новый кладем контент
                .filter(c -> c.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // counting - суммарное кол-во эл-ов

        return nameTopicAndCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // сортировка в обратном порядке
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }


    public List<Integer> topUsersLeftMostComments(List<User> USERS) { // 3 польз. с активность в комментах
        Instant now = Instant.now(); // время сейчас
        LocalDateTime monthAgo = LocalDateTime.of(2000, 1, 1, 1, 1, 1); // время назад
        Map<Integer, List<User>> userAndCountComments = USERS.stream() // key - id юзера value - лист юзеров
                .filter(user -> user.getActionType().equals(ActionType.COMMENT)) // получаем только комменты
                .filter(user -> user.getActionDate().isAfter(monthAgo)) // месяц назад и до сейчас
                .collect(Collectors.groupingBy(User::getId));

        return userAndCountComments.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().size())) // кол-во эл-ов в листе => кол-во комментов
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public List<String> percentageOfActions(List<User> USERS) { // сколько процентов людей исп. тот или иной тип активности
        int countOfUsers = USERS.size(); // кол-во юзеров (ячеек)
        DecimalFormat decimalFormat = new DecimalFormat("0.0"); // задаем формат

        Map<ActionType, List<User>> typeAndUser = USERS.stream() // key - тип активности value - лист юзеров
                .collect(Collectors.groupingBy(User::getActionType));
        return typeAndUser.entrySet().stream()
                .map(u -> {
                    ActionType actionType = u.getKey(); // сохр. ключи
                    List<User> listWhoUsedThatTypeOfAction = u.getValue(); // люди которые испол. конкренный тип активности
                    double percentage = (double) listWhoUsedThatTypeOfAction.size() / countOfUsers * 100; // расчет процента
                    return actionType + ": " + decimalFormat.format(percentage) + "%"; // ("share: 00%", "comm: 00%"); // шаблон вывода
                }).collect(toList());
    }
}
