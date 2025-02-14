package bjs257883;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {
    public List<Map<String, String>> findPeopleWithMutualFriends (Map<String, List<String>> StringToFriends) {
        return findMutualFriendsFromStrangers(StringToFriends);
    }

    private List<String> getPeopleWhoAreNotFriends(Map<String, List<String>> humanToFriends) {
        List<String> peopleWhoAreNotFriends = new ArrayList<>();
        humanToFriends.forEach((key, value) -> {
            Map<String, List<String>> currentFriends = new HashMap<>();
            currentFriends.put(key, humanToFriends.get(key));
            Set<String> namesSet = humanToFriends.keySet();
            List<String> currentPeopleWhoAreNotFriends = namesSet.stream().filter(human -> !currentFriends.get(key).contains(human)).toList();
            peopleWhoAreNotFriends.addAll(currentPeopleWhoAreNotFriends);

        });
        return peopleWhoAreNotFriends;
    }

    private List<Map<String, String>>
    findMutualFriendsFromStrangers(Map<String, List<String>> humanToFriends) {
        List<Map<String, String>> peopleWithMutualFriends = new ArrayList<>();
        List<String> peopleWhoAreNotFriends = getPeopleWhoAreNotFriends(humanToFriends);
        IntStream.range(0, peopleWhoAreNotFriends.size() - 1)
                .forEach(i -> peopleWhoAreNotFriends
                        .forEach(externalString -> {
                            List<String> externalStrings = humanToFriends.get(externalString);
                            peopleWhoAreNotFriends
                                    .forEach(internalString -> {
                                        if (!externalString.equals(internalString)) {
                                            List<String> internalStrings = humanToFriends.get(internalString);
                                            if (!Collections.disjoint(externalStrings, internalStrings)) {
                                                Map<String, String> pairWithMutualFriends = externalStrings.stream()
                                                        .filter(internalStrings::contains)
                                                        .collect(Collectors.toMap(key -> internalString, value -> externalString));
                                                peopleWithMutualFriends.add(pairWithMutualFriends);
                                            }
                                        }
                                    });
                        }));
        return peopleWithMutualFriends;
    }
}