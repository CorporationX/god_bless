package faang.school.godbless.AnalysisOfUserActivity;

import faang.school.godbless.groupUsersByAge.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Actions {

    public List<Integer> find10MostActivityUsers(List<UserAction> list){
        Map<Integer,List<UserAction>> map = list.stream()
                .collect(Collectors.groupingBy(UserAction::id));

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<UserAction>>comparingByValue(
                                Comparator.comparingInt(List::size))
                        .reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public List<String> findTop5HashTags(List<UserAction> list){


    }

    public List<Integer> findTop3UsersByComments(){

    }

    public List<String> getActionsPercentage(){

    }
}
