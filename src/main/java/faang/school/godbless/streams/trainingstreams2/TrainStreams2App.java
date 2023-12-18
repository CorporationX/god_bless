package faang.school.godbless.streams.trainingstreams2;

import lombok.Data;

import java.util.*;

import static faang.school.godbless.streams.trainingstreams2.StreamsUtil.*;

public class TrainStreams2App {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 9, 5, 3, 4, 6, 58, 4, 2, 5, 6, 3, 1, 58, 55, 6, 8, 5, 5, 21, 4, 2, 3, 6, 5, 54, 7, 78, 5, 5, 4, 41, 1, 2, 36, 9, 98, 7, 7, 899, 5);
        Map<String, String> countriesCapitals = Map.of("Russia", "Moscow", "United States", "Washington D.C.",
                "China", "Beijing", "Japan", "Tokyo", "Germany", "Berlin", "India", "New Delhi",
                "Brazil", "Brasília", "France", "Paris", "Italy", "Rome", "Canada", "Ottawa");
        Map<String, List<String>> people = Map.of(
                "user1", List.of("user99", "user98"),
                "user2", List.of("user99", "user98"),
                "user3", List.of("user96", "user97"),
                "user4", List.of("user96", "user97"));

        Map<Integer, Integer> uniquePairs = uniquePairsStreams(list, 10);
        System.out.println("uniquePairs = " + uniquePairs);

        printCapitals(countriesCapitals);

        List<String> filterByCharAndSortByLength = filterByCharAndSortByLength('b', new ArrayList<>(countriesCapitals.values()));
        System.out.println("filterByCharAndSortByLength = " + filterByCharAndSortByLength);

        Map<String, String> potentialFriends = findPotentialFriends(people);
        System.out.println("potentialFriends = " + potentialFriends);


    }

}
