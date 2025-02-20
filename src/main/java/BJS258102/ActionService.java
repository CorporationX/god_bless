package BJS258102;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class ActionService {
    private final HashMap<Integer, List<UserAction>> userActionHashMap = new HashMap<>();

    public HashMap<Integer, List<UserAction>> addUserAction(UserAction userAction) {
        if (userAction == null) {
            throw new NullPointerException("userAction is null");
        }
        userActionHashMap.computeIfAbsent(userAction.getId(), k -> new ArrayList<>()).add(userAction);
        return userActionHashMap;
    }

    public List<String> getTopMostActivity(HashMap<Integer, List<UserAction>> userActionHashMap, int top) {
        log.info("Get TOP| " + top + " |most activity");
        return userActionHashMap.entrySet().stream()
                .sorted((u1, u2) ->
                        Integer.compare(u2.getValue().size(), u1.getValue().size()))
                .limit(top)
                .map(entry -> entry.getValue()
                        .get(0)
                        .getName())
                .collect(Collectors.toList());

    }

    public List<String> getTopHashtag(HashMap<Integer, List<UserAction>> userActionHashMap, int top) {
        log.info("Get TOP| " + top + " |hashtag");

        return userActionHashMap.entrySet().stream()
                // Разворачиваем список действий пользователя в поток
                .flatMap(entry -> entry.getValue().stream())
                // Извлекаем каждое действие
                .map(UserAction::getContent)
                // Разбиваем строку на отдельные слова
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                // Оставляем только слова с #
                .filter(word -> word.startsWith("#"))
                // Подсчитываем количество вхождений каждого хэштега
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                // Получаем поток (хэштег, количество упоминаний)
                .entrySet().stream()
                // Сортируем по количеству упоминаний от большего к меньшему
                .sorted((entry1, entry2) ->
                        Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(top)
                .map(Map.Entry::getKey)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getTopComment(HashMap<Integer, List<UserAction>> userActionHashMap, int top) {
        log.info("Get TOP| " + top + " |comment");
        return userActionHashMap.entrySet().stream()
                // Разворачиваем список действий пользователя в поток
                .flatMap(entry -> entry.getValue().stream()
                        // Ищем action с именем comment
                        .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                        //сохраняем в абстрактную мап пользователя и действие
                        .map(action -> new AbstractMap.SimpleEntry<>(entry.getKey(), action)))
                //считаем кол-во комментов по Id
                .collect(Collectors.groupingBy(entry ->
                        entry.getKey(), Collectors.counting()))
                // поток пользователей и кол-во комментов
                .entrySet().stream()
                //сортируем
                .sorted((entry1, entry2)
                        -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(top)
                //получаем имя пользователей из userActionHashMap
                .map(entry -> userActionHashMap.get(entry.getKey()).get(0).getName())
                .toList();

    }

    public Map<String, Double> getPercentage(HashMap<Integer, List<UserAction>> userActionHashMap) {
        log.info("Get percentage");
        long allActions = userActionHashMap.values().stream()
                .mapToLong(List::size)
                .sum();

        return userActionHashMap.values().stream()
                .flatMap(List::stream)
                //группируема по ActionType и считаем кол-во
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                //собираем мап ActionName - процентное соотношение
                .collect(Collectors.toMap(entry -> entry.getKey().getActionName(),
                        entry -> ((entry.getValue() * 100.0) / allActions)));
    }

}
