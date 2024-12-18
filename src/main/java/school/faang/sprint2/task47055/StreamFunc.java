package school.faang.sprint2.task47055;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFunc {

    public static List<List<String>> getFriendsOfFriends(Map<String, List<String>> friends) {

        friends.entrySet()
                .stream()
                //.peek(System.out::println)
                .flatMap(friend1 -> friends.entrySet().stream()
                                .filter(friend2 -> {
                                    //friends.get
                                    //return friends.get(friend1.getKey()).contains(friend2.getKey());
                                    //System.out.println("===" + friend1.getKey() +" ? "+ friend2.getKey());
                                    if (friend1.getKey().equals(friend2.getKey())) {
                                        return false;
                                    }
                                    //System.out.println("===" + friend1.getKey() +" <> "+ friend2.getKey());
                                    //if (friend2.getValue().contains(friend1.getKey()))
                                    if (friend1.getValue().contains(friend2.getKey())) {
                                        //System.out.println(friend1.getKey() +" дружит с "+ friend2.getKey());
                                        if (friends.get(friend2.getKey()).contains(friend1.getKey())) {
                                            System.out.println("Для " + friend1.getKey() + " нашли " + friend2.getKey());
                                            //System.out.println(">>>" + friend2.getKey() +" дружит с "+ friend1.getKey());
                                            return true;
                                        } else {
                                            return false;
                                        }

                                    } else {
                                        return false;
                                    }

                                })
                        .map(result -> Arrays.asList(friend1.getKey(), result.getKey()))
                                        //.peek(System.out::println)
                                        //.stream().toList()
                        //.filter(subfriend -> subfriend.stream().anyMatch(subfriend.stream().anyMatch(friend.get)))
                        //.filter(subfriend -> subfriend.stream().anyMatch(friends.get(subfriend)::contains))
                )
                        //.toList();
                        //.collect(Collectors.toList());
                .map(list -> list.stream()
                        .sorted()
                        .distinct()
                        .toList())
                .peek(System.out::println)
                //.map(result -> result)
                .toList();

        return null;

    }

    //задача 46860
    public static List<List<String>> getCrossFriends(Map<String, List<String>> peopleWithFriends) {
        return peopleWithFriends.entrySet()
                .stream()
                .flatMap(person1 -> peopleWithFriends.entrySet()
                        .stream()
                        .filter(person2 -> {
                            if (person1.getKey().equals(person2.getKey())) {
                                return false;
                            }
                            if (person1.getValue().contains(person2.getKey())) {
                                return false;
                            }
                            HashSet<String> commonFriends = new HashSet<>(person1.getValue());
                            commonFriends.addAll(person2.getValue());
                            return !commonFriends.isEmpty();
                        })
                        .map(person2 -> Arrays.asList(person1.getKey(), person2.getKey()))
                        .map(list -> list.stream()
                                .sorted()
                                .toList()))
                .distinct()
                .toList();
    }

    //47484
    public static Set<List<String>> findNonFriendsWithCommonFriends(Map<String, List<String>> usersFriends) {
        return usersFriends.keySet().stream()
                .flatMap(user -> usersFriends.keySet().stream()
                        .filter(friend -> !user.equals(friend)
                                &&
                                !usersFriends.get(user).contains(friend)
                                &&
                                usersFriends.get(user).stream().anyMatch(usersFriends.get(friend)::contains))
                        .map(friend -> {
                            List<String> pair = new ArrayList<>(Arrays.asList(user, friend));
                            Collections.sort(pair); // Сортируем для уникальности
                            return pair;
                        }))
                .collect(Collectors.toSet());
    }
}
