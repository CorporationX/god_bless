package faang.school.godbless.sprint3.streams.analysUsers.classes;

import faang.school.godbless.sprint3.streams.analysUsers.enums.ActionType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analyser {

    public static List<UserAction> findTopActiveUsersForAction(List<UserAction> list) {
        list.stream()
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream()
                .collect(Collectors.counting())
    }
